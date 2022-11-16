
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "content",
    "type",
    "attrs"
})
@Generated("jsonschema2pojo")
public class Content__1 {

    @JsonProperty("content")
    private List<Content__2> content = null;
    @JsonProperty("type")
    private String type;
    @JsonProperty("attrs")
    private Attrs attrs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("content")
    public List<Content__2> getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(List<Content__2> content) {
        this.content = content;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("attrs")
    public Attrs getAttrs() {
        return attrs;
    }

    @JsonProperty("attrs")
    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
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
