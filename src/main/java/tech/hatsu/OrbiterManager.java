package tech.hatsu;

import tech.hatsu.discord.DiscordOrbiterUpdater;
import tech.hatsu.manifold.OrbitStockManager;
import tech.hatsu.manifold.model.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbiterManager {
    private OrbitStockManager orbitStockManager = new OrbitStockManager();
    private DiscordOrbiterUpdater discordOrbiterUpdater = new DiscordOrbiterUpdater();

    public OrbiterManager() {
    }

    public List<Orbiter> getCurrentOrbitersInRoom() {
        List<String> currentOrbitersInRoom = discordOrbiterUpdater.getCurrentOrbitersInRoom();

        List<Orbiter> result = new ArrayList<>();
        for (String orbiterName : currentOrbitersInRoom) {
            String normalizedOrbiterName = orbiterName.toLowerCase();
            Optional<Market> popularMarketForOrbiter = orbitStockManager.getPopularMarketForOrbiter(orbiterName);
            if (popularMarketForOrbiter.isEmpty()) {
                continue;
            }
            Market orbiterMarket = popularMarketForOrbiter.get();

            String value = String.format("%.2f", orbiterMarket.getProbability());
            Orbiter orbiter = new Orbiter(normalizedOrbiterName, orbiterMarket.getId(), orbiterMarket.getUrl(), value);
            result.add(orbiter);
        }

        return result;
    }
}
