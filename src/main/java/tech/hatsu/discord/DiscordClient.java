package tech.hatsu.discord;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import tech.hatsu.discord.model.HelloData;
import tech.hatsu.discord.model.VoiceStateUpdate;
import tech.hatsu.helper.OrbiterEvent;
import tech.hatsu.helper.SubscriberInterface;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;

public class DiscordClient extends WebSocketClient {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static final int HELLO_EVENT = 10;
    private static Logger logger = LogManager.getLogger();
    private static final URI DGG_SOCKET_URL;

    static {
        try {
            DGG_SOCKET_URL = new URI("wss://gateway.discord.gg/?encoding=json&v=9"); // Make sure not to use compression.
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private final SubscriberInterface subscriber;

    public DiscordClient(SubscriberInterface subscriber) {
        super(DGG_SOCKET_URL);
        logger.info("client");
        this.subscriber = subscriber;
    }

    // TODO Should not be used... Only to satisfy superclass.
    public DiscordClient(URI serverUri) {
        super(serverUri);
        this.subscriber = null;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        logger.info("Opened Discord connection");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.send("{\"op\":2,\"d\":{\"token\":\"MTA0MjQzNzYyMjc4MzU0OTU3MA.GN-uRh.Hf1H5GmJD0ZFQLbyngODm_AirUTNREA2hsVrE4\",\"capabilities\":4093,\"properties\":{\"os\":\"Linux\",\"browser\":\"Chrome\",\"device\":\"\",\"system_locale\":\"en-US\",\"browser_user_agent\":\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36\",\"browser_version\":\"100.0.4896.127\",\"os_version\":\"\",\"referrer\":\"\",\"referring_domain\":\"\",\"referrer_current\":\"\",\"referring_domain_current\":\"\",\"release_channel\":\"stable\",\"client_build_number\":159692,\"client_event_source\":null},\"presence\":{\"status\":\"unknown\",\"since\":0,\"activities\":[],\"afk\":false},\"compress\":false,\"client_state\":{\"guild_versions\":{},\"highest_last_message_id\":\"0\",\"read_state_version\":0,\"user_guild_settings_version\":-1,\"user_settings_version\":-1,\"private_channels_version\":\"0\",\"api_code_version\":0}}}");
        logger.info("Send init");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    // TODO Business logic in client... Maybe we can pass what it should do from manager or something?
    @Override
    public void onMessage(String message) {
        try {
            DiscordEvent discordEvent = objectMapper.readValue(message, DiscordEvent.class);
//            handleHelloEvent(message, discordEvent); // Not really necessary... We expect this to happen and create a heartbeat interval ourselves

            String d = objectMapper.writeValueAsString(discordEvent.getD());

            String t = discordEvent.getT();
            // Not sure why but t can be null
            if (t == null) {
                logger.info("Message t was null: {}", message);
                return;
            }

            if (t.equalsIgnoreCase("VOICE_STATE_UPDATE")) {


                VoiceStateUpdate voiceStateUpdate = objectMapper.readValue(d, VoiceStateUpdate.class);
                String memberId = voiceStateUpdate.getUserId();

                // TODO Unmarshall content of body, find user id
                Instant timestamp = Instant.now();
                OrbiterEvent.Type type = OrbiterEvent.Type.DISCORD_CHANNEL_JOIN;

                if (!DiscordOrbiterMapper.isOrbiter(memberId)) {
                    return;
                }



                String orbiterName = DiscordOrbiterMapper.getName(memberId);

                OrbiterEvent orbiterEvent = new OrbiterEvent(timestamp, type, orbiterName);

                subscriber.update(orbiterEvent);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleHelloEvent(String message, DiscordEvent discordEvent) throws JsonProcessingException {
        if (discordEvent.getOp() == HELLO_EVENT) {
            System.out.println(message);
//                HelloData hello = (HelloData) discordEvent.getD();
            System.out.println("HELLO");
//                System.out.println(hello);

//                System.out.println(hello.getheartbeat_interval());
            System.out.println();
            String d = objectMapper.writeValueAsString(discordEvent.getD());

            HelloData helloData = objectMapper.readValue(d, HelloData.class);

            int heartbeatInterval = helloData.getHeartbeatInterval(); // received value is 41250 multiple times.
            // TODO Could always just be like 20 seconds probably...

//                discordEvent.getD()
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
