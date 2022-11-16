
package tech.hatsu.manifold.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "loanAmount",
    "userName",
    "amount",
    "probAfter",
    "fills",
    "id",
    "fees",
    "probBefore",
    "outcome",
    "userUsername",
    "contractId",
    "createdTime",
    "shares",
    "isCancelled",
    "userAvatarUrl",
    "userId",
    "isFilled",
    "orderAmount"
})
@Generated("jsonschema2pojo")
public class Bet {

    @JsonProperty("loanAmount")
    private int loanAmount;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("probAfter")
    private double probAfter;
    @JsonProperty("fills")
    private List<Fill> fills = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("fees")
    private Fees fees;
    @JsonProperty("probBefore")
    private double probBefore;
    @JsonProperty("outcome")
    private String outcome;
    @JsonProperty("userUsername")
    private String userUsername;
    @JsonProperty("contractId")
    private String contractId;
    @JsonProperty("createdTime")
    private long createdTime;
    @JsonProperty("shares")
    private double shares;
    @JsonProperty("isCancelled")
    private boolean isCancelled;
    @JsonProperty("userAvatarUrl")
    private String userAvatarUrl;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("isFilled")
    private boolean isFilled;
    @JsonProperty("orderAmount")
    private int orderAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("loanAmount")
    public int getLoanAmount() {
        return loanAmount;
    }

    @JsonProperty("loanAmount")
    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("amount")
    public int getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @JsonProperty("probAfter")
    public double getProbAfter() {
        return probAfter;
    }

    @JsonProperty("probAfter")
    public void setProbAfter(double probAfter) {
        this.probAfter = probAfter;
    }

    @JsonProperty("fills")
    public List<Fill> getFills() {
        return fills;
    }

    @JsonProperty("fills")
    public void setFills(List<Fill> fills) {
        this.fills = fills;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("fees")
    public Fees getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(Fees fees) {
        this.fees = fees;
    }

    @JsonProperty("probBefore")
    public double getProbBefore() {
        return probBefore;
    }

    @JsonProperty("probBefore")
    public void setProbBefore(double probBefore) {
        this.probBefore = probBefore;
    }

    @JsonProperty("outcome")
    public String getOutcome() {
        return outcome;
    }

    @JsonProperty("outcome")
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @JsonProperty("userUsername")
    public String getUserUsername() {
        return userUsername;
    }

    @JsonProperty("userUsername")
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @JsonProperty("contractId")
    public String getContractId() {
        return contractId;
    }

    @JsonProperty("contractId")
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    @JsonProperty("createdTime")
    public long getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("createdTime")
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @JsonProperty("shares")
    public double getShares() {
        return shares;
    }

    @JsonProperty("shares")
    public void setShares(double shares) {
        this.shares = shares;
    }

    @JsonProperty("isCancelled")
    public boolean isIsCancelled() {
        return isCancelled;
    }

    @JsonProperty("isCancelled")
    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @JsonProperty("userAvatarUrl")
    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    @JsonProperty("userAvatarUrl")
    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("isFilled")
    public boolean isIsFilled() {
        return isFilled;
    }

    @JsonProperty("isFilled")
    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @JsonProperty("orderAmount")
    public int getOrderAmount() {
        return orderAmount;
    }

    @JsonProperty("orderAmount")
    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
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
