
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alt",
    "src",
    "title"
})
@Generated("jsonschema2pojo")
public class Attrs {

    @JsonProperty("alt")
    private Object alt;
    @JsonProperty("src")
    private String src;
    @JsonProperty("title")
    private Object title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("alt")
    public Object getAlt() {
        return alt;
    }

    @JsonProperty("alt")
    public void setAlt(Object alt) {
        this.alt = alt;
    }

    @JsonProperty("src")
    public String getSrc() {
        return src;
    }

    @JsonProperty("src")
    public void setSrc(String src) {
        this.src = src;
    }

    @JsonProperty("title")
    public Object getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Object title) {
        this.title = title;
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
