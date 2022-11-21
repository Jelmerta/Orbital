package tech.hatsu.dgg;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class DggClient extends WebSocketClient {
    private static Logger logger = LogManager.getLogger();
    private static final URI DGG_SOCKET_URL;

    static {
        try {
            DGG_SOCKET_URL = new URI("wss://chat.destiny.gg/ws");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private final DggChatManager dggChatManager;

    public DggClient(DggChatManager dggChatManager) {
        super(DGG_SOCKET_URL);
        this.dggChatManager = dggChatManager;
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
            dggChatManager.handleCommand(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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
}
