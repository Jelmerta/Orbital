
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NO",
    "YES"
})
@Generated("jsonschema2pojo")
public class Pool {

    @JsonProperty("NO")
    private double no;
    @JsonProperty("YES")
    private double yes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("NO")
    public double getNo() {
        return no;
    }

    @JsonProperty("NO")
    public void setNo(double no) {
        this.no = no;
    }

    @JsonProperty("YES")
    public double getYes() {
        return yes;
    }

    @JsonProperty("YES")
    public void setYes(double yes) {
        this.yes = yes;
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
