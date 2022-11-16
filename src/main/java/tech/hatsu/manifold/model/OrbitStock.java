
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "creatorId",
    "creatorUsername",
    "creatorName",
    "createdTime",
    "creatorAvatarUrl",
    "closeTime",
    "question",
    "tags",
    "url",
    "pool",
    "probability",
    "p",
    "totalLiquidity",
    "outcomeType",
    "mechanism",
    "volume",
    "volume7Days",
    "volume24Hours",
    "isResolved",
    "lastUpdatedTime",
    "comments",
    "bets",
    "description",
    "textDescription"
})
@Generated("jsonschema2pojo")
public class OrbitStock {

    @JsonProperty("id")
    private String id;
    @JsonProperty("creatorId")
    private String creatorId;
    @JsonProperty("creatorUsername")
    private String creatorUsername;
    @JsonProperty("creatorName")
    private String creatorName;
    @JsonProperty("createdTime")
    private long createdTime;
    @JsonProperty("creatorAvatarUrl")
    private String creatorAvatarUrl;
    @JsonProperty("closeTime")
    private long closeTime;
    @JsonProperty("question")
    private String question;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("url")
    private String url;
    @JsonProperty("pool")
    private Pool pool;
    @JsonProperty("probability")
    private double probability;
    @JsonProperty("p")
    private double p;
    @JsonProperty("totalLiquidity")
    private int totalLiquidity;
    @JsonProperty("outcomeType")
    private String outcomeType;
    @JsonProperty("mechanism")
    private String mechanism;
    @JsonProperty("volume")
    private double volume;
    @JsonProperty("volume7Days")
    private double volume7Days;
    @JsonProperty("volume24Hours")
    private double volume24Hours;
    @JsonProperty("isResolved")
    private boolean isResolved;
    @JsonProperty("lastUpdatedTime")
    private long lastUpdatedTime;
    @JsonProperty("comments")
    private List<Comment> comments = null;
    @JsonProperty("bets")
    private List<Bet> bets = null;
    @JsonProperty("description")
    private Description description;
    @JsonProperty("textDescription")
    private String textDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("creatorId")
    public String getCreatorId() {
        return creatorId;
    }

    @JsonProperty("creatorId")
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @JsonProperty("creatorUsername")
    public String getCreatorUsername() {
        return creatorUsername;
    }

    @JsonProperty("creatorUsername")
    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    @JsonProperty("creatorName")
    public String getCreatorName() {
        return creatorName;
    }

    @JsonProperty("creatorName")
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @JsonProperty("createdTime")
    public long getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("createdTime")
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("creatorAvatarUrl")
    public String getCreatorAvatarUrl() {
        return creatorAvatarUrl;
    }

    @JsonProperty("creatorAvatarUrl")
    public void setCreatorAvatarUrl(String creatorAvatarUrl) {
        this.creatorAvatarUrl = creatorAvatarUrl;
    }

    @JsonProperty("closeTime")
    public long getCloseTime() {
        return closeTime;
    }

    @JsonProperty("closeTime")
    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
    }

    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }

    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("pool")
    public Pool getPool() {
        return pool;
    }

    @JsonProperty("pool")
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    @JsonProperty("probability")
    public double getProbability() {
        return probability;
    }

    @JsonProperty("probability")
    public void setProbability(double probability) {
        this.probability = probability;
    }

    @JsonProperty("p")
    public double getP() {
        return p;
    }

    @JsonProperty("p")
    public void setP(double p) {
        this.p = p;
    }

    @JsonProperty("totalLiquidity")
    public int getTotalLiquidity() {
        return totalLiquidity;
    }

    @JsonProperty("totalLiquidity")
    public void setTotalLiquidity(int totalLiquidity) {
        this.totalLiquidity = totalLiquidity;
    }

    @JsonProperty("outcomeType")
    public String getOutcomeType() {
        return outcomeType;
    }

    @JsonProperty("outcomeType")
    public void setOutcomeType(String outcomeType) {
        this.outcomeType = outcomeType;
    }

    @JsonProperty("mechanism")
    public String getMechanism() {
        return mechanism;
    }

    @JsonProperty("mechanism")
    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    @JsonProperty("volume")
    public double getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @JsonProperty("volume7Days")
    public double getVolume7Days() {
        return volume7Days;
    }

    @JsonProperty("volume7Days")
    public void setVolume7Days(double volume7Days) {
        this.volume7Days = volume7Days;
    }

    @JsonProperty("volume24Hours")
    public double getVolume24Hours() {
        return volume24Hours;
    }

    @JsonProperty("volume24Hours")
    public void setVolume24Hours(double volume24Hours) {
        this.volume24Hours = volume24Hours;
    }

    @JsonProperty("isResolved")
    public boolean isIsResolved() {
        return isResolved;
    }

    @JsonProperty("isResolved")
    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

    @JsonProperty("lastUpdatedTime")
    public long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    @JsonProperty("lastUpdatedTime")
    public void setLastUpdatedTime(long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty("bets")
    public List<Bet> getBets() {
        return bets;
    }

    @JsonProperty("bets")
    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    @JsonProperty("textDescription")
    public String getTextDescription() {
        return textDescription;
    }

    @JsonProperty("textDescription")
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
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
