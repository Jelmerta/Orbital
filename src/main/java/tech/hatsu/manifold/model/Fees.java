
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "liquidityFee",
    "platformFee",
    "creatorFee"
})
@Generated("jsonschema2pojo")
public class Fees {

    @JsonProperty("liquidityFee")
    private int liquidityFee;
    @JsonProperty("platformFee")
    private int platformFee;
    @JsonProperty("creatorFee")
    private int creatorFee;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("liquidityFee")
    public int getLiquidityFee() {
        return liquidityFee;
    }

    @JsonProperty("liquidityFee")
    public void setLiquidityFee(int liquidityFee) {
        this.liquidityFee = liquidityFee;
    }

    @JsonProperty("platformFee")
    public int getPlatformFee() {
        return platformFee;
    }

    @JsonProperty("platformFee")
    public void setPlatformFee(int platformFee) {
        this.platformFee = platformFee;
    }

    @JsonProperty("creatorFee")
    public int getCreatorFee() {
        return creatorFee;
    }

    @JsonProperty("creatorFee")
    public void setCreatorFee(int creatorFee) {
        this.creatorFee = creatorFee;
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
