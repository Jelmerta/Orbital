
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "shares",
    "amount",
    "matchedBetId",
    "timestamp",
    "isSale"
})
@Generated("jsonschema2pojo")
public class Fill {

    @JsonProperty("shares")
    private double shares;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("matchedBetId")
    private Object matchedBetId;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("isSale")
    private boolean isSale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("shares")
    public double getShares() {
        return shares;
    }

    @JsonProperty("shares")
    public void setShares(double shares) {
        this.shares = shares;
    }

    @JsonProperty("amount")
    public int getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @JsonProperty("matchedBetId")
    public Object getMatchedBetId() {
        return matchedBetId;
    }

    @JsonProperty("matchedBetId")
    public void setMatchedBetId(Object matchedBetId) {
        this.matchedBetId = matchedBetId;
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("isSale")
    public boolean isIsSale() {
        return isSale;
    }

    @JsonProperty("isSale")
    public void setIsSale(boolean isSale) {
        this.isSale = isSale;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
