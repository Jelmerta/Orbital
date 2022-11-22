package tech.hatsu.discord;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.hatsu.helper.SubscriberInterface;
import tech.hatsu.orbiter.OrbiterManager;

import java.util.concurrent.*;

public class DiscordChannelManager {
    private final SubscriberInterface subscriber;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = LogManager.getLogger();

    public DiscordChannelManager(OrbiterManager orbiterManager) {
        this.subscriber = orbiterManager;
        runClient();
    }

    private void runClient() {
        try {
            DiscordClient discordClient = new DiscordClient(subscriber);
            discordClient.connect();
            Thread.sleep(2000); // Wait a bit until connected TODO Better solution

            Runnable sendHeartbeats = () -> {
                DiscordEvent heartbeat = new DiscordEvent();
                heartbeat.setOp(1);
                heartbeat.setD(null); // TODO Add follow in d?
                try {
                    logger.info("sending heartbeat");
                    discordClient.send(objectMapper.writeValueAsString(heartbeat));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            };

            // client isOpen()...
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(sendHeartbeats, 0, 20, TimeUnit.SECONDS);

            // TODO THIS BLOCKS THREAD
//            while (discordClient.isOpen()) {
//                Thread.sleep(20 * 1000);
//                DiscordEvent heartbeat = new DiscordEvent();
//                heartbeat.setOp(1);
//                heartbeat.setD(null); // TODO Add follow in d?
//                logger.info("sending heartbeat");
//                discordClient.send(objectMapper.writeValueAsString(heartbeat));
//                logger.info("sent heartbeat");
//            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
