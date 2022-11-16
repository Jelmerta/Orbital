package tech.hatsu;

import tech.hatsu.discord.DiscordOrbiterScraper;
import tech.hatsu.manifold.OrbitStockManager;
import tech.hatsu.manifold.model.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbiterManager {
    private OrbitStockManager orbitStockManager = new OrbitStockManager();
    private DiscordOrbiterScraper discordOrbiterScraper = new DiscordOrbiterScraper();

    public OrbiterManager() {
    }

    public List<Orbiter> getCurrentOrbitersInRoom() {
        List<String> currentOrbitersInRoom = discordOrbiterScraper.getCurrentOrbitersInRoom();

        List<Orbiter> result = new ArrayList<>();
        for (String orbiterName : currentOrbitersInRoom) {
            Optional<Market> popularMarketForOrbiter = orbitStockManager.getPopularMarketForOrbiter(orbiterName);
            if (popularMarketForOrbiter.isEmpty()) {
                continue;
            }
            Market orbiterMarket = popularMarketForOrbiter.get();

            String value = String.format("%.2f", orbiterMarket.getProbability());
            Orbiter orbiter = new Orbiter(orbiterName, orbiterMarket.getId(), orbiterMarket.getUrl(), value);
            result.add(orbiter);
        }

        return result;
    }
}
