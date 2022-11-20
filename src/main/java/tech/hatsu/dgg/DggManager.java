package tech.hatsu.dgg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class DggManager extends WebSocketClient {
    private static Logger logger = LogManager.getLogger();

    public DggManager(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        logger.info("Opened DGG connection");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    @Override
    public void onMessage(String message) {
//        logger.info("received: " + message); // Debug
        try {
            handleCommand(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleCommand(String message) throws JsonProcessingException {
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

        logger.info("Found an orbiter message! " + msgCommand.getNick() + " just said " + msgCommand.getData());
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // The close codes are documented in class org.java_websocket.framing.CloseFrame
        logger.info("Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        DggManager c = new DggManager(new URI("wss://chat.destiny.gg/ws"));
        c.connect();
        Thread.sleep(2000); // Provide some startup time before checking liveliness
        while (c.isOpen()) {
            logger.info("Still alive"); // Should be managed by docker probably?
            Thread.sleep(300000); // 5 minutes
        }
        logger.info("Help! Bad liveliness, quiting.");
    }
}