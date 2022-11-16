
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "commenterPositionShares",
    "contractId",
    "userAvatarUrl",
    "commenterPositionProb",
    "betAmount",
    "createdTime",
    "contractSlug",
    "betOutcome",
    "commentType",
    "contractQuestion",
    "content",
    "userName",
    "commenterPositionOutcome",
    "userUsername",
    "betId",
    "userId",
    "id"
})
@Generated("jsonschema2pojo")
public class Comment {

    @JsonProperty("commenterPositionShares")
    private int commenterPositionShares;
    @JsonProperty("contractId")
    private String contractId;
    @JsonProperty("userAvatarUrl")
    private String userAvatarUrl;
    @JsonProperty("commenterPositionProb")
    private double commenterPositionProb;
    @JsonProperty("betAmount")
    private int betAmount;
    @JsonProperty("createdTime")
    private long createdTime;
    @JsonProperty("contractSlug")
    private String contractSlug;
    @JsonProperty("betOutcome")
    private String betOutcome;
    @JsonProperty("commentType")
    private String commentType;
    @JsonProperty("contractQuestion")
    private String contractQuestion;
    @JsonProperty("content")
    private Content content;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("commenterPositionOutcome")
    private String commenterPositionOutcome;
    @JsonProperty("userUsername")
    private String userUsername;
    @JsonProperty("betId")
    private String betId;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("commenterPositionShares")
    public int getCommenterPositionShares() {
        return commenterPositionShares;
    }

    @JsonProperty("commenterPositionShares")
    public void setCommenterPositionShares(int commenterPositionShares) {
        this.commenterPositionShares = commenterPositionShares;
    }

    @JsonProperty("contractId")
    public String getContractId() {
        return contractId;
    }

    @JsonProperty("contractId")
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    @JsonProperty("userAvatarUrl")
    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    @JsonProperty("userAvatarUrl")
    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @JsonProperty("commenterPositionProb")
    public double getCommenterPositionProb() {
        return commenterPositionProb;
    }

    @JsonProperty("commenterPositionProb")
    public void setCommenterPositionProb(double commenterPositionProb) {
        this.commenterPositionProb = commenterPositionProb;
    }

    @JsonProperty("betAmount")
    public int getBetAmount() {
        return betAmount;
    }

    @JsonProperty("betAmount")
    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    @JsonProperty("createdTime")
    public long getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("createdTime")
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("contractSlug")
    public String getContractSlug() {
        return contractSlug;
    }

    @JsonProperty("contractSlug")
    public void setContractSlug(String contractSlug) {
        this.contractSlug = contractSlug;
    }

    @JsonProperty("betOutcome")
    public String getBetOutcome() {
        return betOutcome;
    }

    @JsonProperty("betOutcome")
    public void setBetOutcome(String betOutcome) {
        this.betOutcome = betOutcome;
    }

    @JsonProperty("commentType")
    public String getCommentType() {
        return commentType;
    }

    @JsonProperty("commentType")
    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    @JsonProperty("contractQuestion")
    public String getContractQuestion() {
        return contractQuestion;
    }

    @JsonProperty("contractQuestion")
    public void setContractQuestion(String contractQuestion) {
        this.contractQuestion = contractQuestion;
    }

    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("commenterPositionOutcome")
    public String getCommenterPositionOutcome() {
        return commenterPositionOutcome;
    }

    @JsonProperty("commenterPositionOutcome")
    public void setCommenterPositionOutcome(String commenterPositionOutcome) {
        this.commenterPositionOutcome = commenterPositionOutcome;
    }

    @JsonProperty("userUsername")
    public String getUserUsername() {
        return userUsername;
    }

    @JsonProperty("userUsername")
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @JsonProperty("betId")
    public String getBetId() {
        return betId;
    }

    @JsonProperty("betId")
    public void setBetId(String betId) {
        this.betId = betId;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
