package tech.hatsu.discord.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HelloData {
    @JsonProperty(value = "heartbeat_interval")
    int heartbeatInterval;

    public int getHeartbeatInterval() {
        return heartbeatInterval;
    }


}
