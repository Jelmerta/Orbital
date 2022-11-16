package tech.hatsu;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Orbiter {
    private final String name;
    private final String marketId;
    private final String marketUrl;
    private final String value;

    public Orbiter(String name, String marketId, String marketUrl, String value) {
        this.name = name;
        this.marketId = marketId;
        this.marketUrl = marketUrl;
        this.value = value;
    }

    public String getMarketUrl() {
        return marketUrl;
    }

    public String getMarketId() {
        return marketId;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
