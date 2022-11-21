package tech.hatsu.orbiter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.hatsu.Orbiter;
import tech.hatsu.discord.DiscordOrbiterMapper;
import tech.hatsu.helper.OrbiterEvent;
import tech.hatsu.helper.SubscriberInterface;
import tech.hatsu.manifold.OrbitStockManager;
import tech.hatsu.manifold.model.Market;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbiterManager implements SubscriberInterface {
    private static OrbitStockManager orbitStockManager = new OrbitStockManager();

    // TODO We probably want to clean up older events and only keep a current state for now?
    // TODO Deal with leaving channel?
    private List<OrbiterEvent> orbiterEvents = new ArrayList<>();
    private static Logger logger = LogManager.getLogger();


    public OrbiterManager() {
    }

    public void update(OrbiterEvent orbiterEvent) {
        logger.info("Found update for orbiter!");
        logger.info(orbiterEvent);
        logger.info("\n");
        orbiterEvents.add(orbiterEvent);
    }

    // TODO Maybe the markets for each orbiter should be returned separately?
    public static List<Orbiter> getCurrentOrbitersInRoom() {
        List<String> channelMemberIds = readChannelMemberIds();

        List<Orbiter> result = new ArrayList<>();
        for (String channelMemberId : channelMemberIds) {

            if (!DiscordOrbiterMapper.isOrbiter(channelMemberId)) {
                System.out.println(channelMemberId + " is not an orbiter.");
                continue;
            }

            String orbiterName = DiscordOrbiterMapper.getName(channelMemberId);

            Optional<Market> popularMarketForOrbiter = OrbitStockManager.getPopularMarketForOrbiter(orbiterName);
            if (popularMarketForOrbiter.isEmpty()) {
                System.out.println("Warning: No market found for orbiter " + orbiterName);
                continue;
            }
            Market orbiterMarket = popularMarketForOrbiter.get();

            String value = String.format("%.2f", orbiterMarket.getProbability());
            Orbiter orbiter = new Orbiter(orbiterName, orbiterMarket.getId(), orbiterMarket.getUrl(), value);
            result.add(orbiter);
        }

        return result;
    }

    private static List<String> readChannelMemberIds() {
        String fileName = "/Orbiters/orbiters.txt";
        Path path = Paths.get(fileName);
        try {
            List<String> orbiters = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println(orbiters);
            return orbiters;
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO handle error endpoint nicely...
        }
    }

    public List<OrbiterEvent> getOrbiterEvents() {
        return orbiterEvents;
    }
}
