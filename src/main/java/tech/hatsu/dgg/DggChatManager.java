package tech.hatsu.dgg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.hatsu.helper.OrbiterEvent;
import tech.hatsu.orbiter.OrbiterManager;
import tech.hatsu.helper.SubscriberInterface;

import java.time.Instant;

public class DggChatManager {
    private static Logger logger = LogManager.getLogger();

    DggClient dggClient = new DggClient(this);
    private final SubscriberInterface subscriber;

    public DggChatManager(OrbiterManager orbiterManager) {
        this.subscriber = orbiterManager;

        runClient();
    }

    // TODO Add a way to see liveliness of client
    // TODO THIS BLOCKS THE THREAD
//            while (dggClient.isOpen()) {
//                logger.info("Still alive"); // Should be managed by docker probably?
//                Thread.sleep(5 * 60 * 1000); // 5 minutes
//            }
    private void runClient() {
        logger.info("Starting DGG client");
        dggClient.connect();
    }

    public void handleCommand(String message) throws JsonProcessingException {
        int commandIndex = message.indexOf(" ");

        String command = message.substring(0, commandIndex);
        String messageJson = message.substring(commandIndex + 1);

        if (!command.equals("MSG")) { // No action necessary
            return;
        }

        MsgCommand msgCommand = new ObjectMapper().readValue(messageJson, MsgCommand.class);

        if (!DggOrbiterMapper.isOrbiter(msgCommand.getNick())) {
            return;
        }

        Instant timestamp = Instant.ofEpochSecond(msgCommand.getTimestamp() / 1000, msgCommand.getTimestamp() % 1000); // Timestamp is returned as milliseconds
        OrbiterEvent orbiterEvent = new OrbiterEvent(timestamp, OrbiterEvent.Type.DGG_CHAT, msgCommand.getNick());

        subscriber.update(orbiterEvent);

        logger.info("Found an orbiter message! " + msgCommand.getNick() + " just said " + msgCommand.getData());
    }
}