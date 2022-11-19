package tech.hatsu.manifold;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.hatsu.manifold.model.Market;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OrbitStockManager {
    private static final Map<String, List<Market>> nameToMarkets = new HashMap<>(); // Some duplicates... So we have a list of markets for each name

    public OrbitStockManager() {
        updateMarketsJob();
    }

    public Optional<Market> getPopularMarketForOrbiter(String orbiterName) {
        // TODO This market just added for test case.
        if (orbiterName.equalsIgnoreCase("sweatstiny")) {
            Market market = new Market();

            market.setId("1337");
            market.setUrl("destiny.gg");
            market.setProbability(0.69d);

            return Optional.of(market);
        }

        List<Market> orbiterMarkets = new ArrayList<>();
        for (String marketName : nameToMarkets.keySet()) {
            if (marketName.contains(orbiterName)) { // This check is for stocks like "$PISS Pisco" where the orbiter name is just pisco
                List<Market> market = nameToMarkets.get(orbiterName);
                orbiterMarkets.addAll(market);
            }
        }
        return orbiterMarkets.stream().max(Comparator.comparing(Market::getVolume));
    }

    private void updateMarketsJob() {
        Runnable updateMarkets = () -> {
            System.out.println("Executing market update task");
            loadMarkets();
            System.out.println("Executed market update task");
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(updateMarkets, 0, 300, TimeUnit.SECONDS); // New markets aren't added too much... I mean, frontend could also simply retrieve the price here, in which case we do want to update all the time.
    }

    public static void loadMarkets() {
        System.out.println("Loading Manifold markets");
        List<Market> manifoldMarkets = getMarkets();
        for (Market market : manifoldMarkets) {
            String question = market.getQuestion();
            int index = question.lastIndexOf(" Stock (Permanent)"); // TODO Would be nice if the markets were somehow marked as orbiter markets... Now retrieving a few too many.
            if (index == -1) { // Probably not an orbiter stock if it is not permanent...
                continue;
            }
            String name = question.substring(0, index);
            String lowerCaseName = name.toLowerCase(); // Normalized
            System.out.println(lowerCaseName);

            List<Market> marketsForName = nameToMarkets.getOrDefault(name, new ArrayList<>());
            marketsForName.add(market);
            nameToMarkets.put(lowerCaseName, marketsForName);
        }

        System.out.println("MARKET LOADED:");
        System.out.println(nameToMarkets);
    }

    private static List<Market> getMarkets() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://manifold.markets/api/v0/group/by-id/W2ES30fRo6CCbPNwMTTj/markets")).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), new TypeReference<>() {
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}