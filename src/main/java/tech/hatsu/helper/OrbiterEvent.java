package tech.hatsu.helper;

import java.time.Instant;

public class OrbiterEvent {
    Instant timestamp;
    Type type;
    String orbiterName;

//    String message;

    public OrbiterEvent(Instant timestamp, Type type, String orbiterName) {
        this.timestamp = timestamp;
        this.type = type;
        this.orbiterName = orbiterName;
//        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Type getType() {
        return type;
    }

//    public String getMessage() {
//        return message;
//    }


    public String getOrbiterName() {
        return orbiterName;
    }

    public enum Type {
        DISCORD_CHANNEL_JOIN,
        //        DISCORD_CHAT?
        DGG_CHAT
    }
}
