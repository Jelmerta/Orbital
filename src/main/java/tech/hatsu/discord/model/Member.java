package tech.hatsu.discord.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"user",
"roles",
"premium_since",
"pending",
"nick",
"mute",
"joined_at",
"flags",
"deaf",
"communication_disabled_until",
"avatar"
})
@Generated("jsonschema2pojo")
public class Member {

@JsonProperty("user")
private User user;
@JsonProperty("roles")
private List<Object> roles = null;
@JsonProperty("premium_since")
private Object premiumSince;
@JsonProperty("pending")
private boolean pending;
@JsonProperty("nick")
private Object nick;
@JsonProperty("mute")
private boolean mute;
@JsonProperty("joined_at")
private String joinedAt;
@JsonProperty("flags")
private int flags;
@JsonProperty("deaf")
private boolean deaf;
@JsonProperty("communication_disabled_until")
private Object communicationDisabledUntil;
@JsonProperty("avatar")
private Object avatar;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("user")
public User getUser() {
return user;
}

@JsonProperty("user")
public void setUser(User user) {
this.user = user;
}

@JsonProperty("roles")
public List<Object> getRoles() {
return roles;
}

@JsonProperty("roles")
public void setRoles(List<Object> roles) {
this.roles = roles;
}

@JsonProperty("premium_since")
public Object getPremiumSince() {
return premiumSince;
}

@JsonProperty("premium_since")
public void setPremiumSince(Object premiumSince) {
this.premiumSince = premiumSince;
}

@JsonProperty("pending")
public boolean isPending() {
return pending;
}

@JsonProperty("pending")
public void setPending(boolean pending) {
this.pending = pending;
}

@JsonProperty("nick")
public Object getNick() {
return nick;
}

@JsonProperty("nick")
public void setNick(Object nick) {
this.nick = nick;
}

@JsonProperty("mute")
public boolean isMute() {
return mute;
}

@JsonProperty("mute")
public void setMute(boolean mute) {
this.mute = mute;
}

@JsonProperty("joined_at")
public String getJoinedAt() {
return joinedAt;
}

@JsonProperty("joined_at")
public void setJoinedAt(String joinedAt) {
this.joinedAt = joinedAt;
}

@JsonProperty("flags")
public int getFlags() {
return flags;
}

@JsonProperty("flags")
public void setFlags(int flags) {
this.flags = flags;
}

@JsonProperty("deaf")
public boolean isDeaf() {
return deaf;
}

@JsonProperty("deaf")
public void setDeaf(boolean deaf) {
this.deaf = deaf;
}

@JsonProperty("communication_disabled_until")
public Object getCommunicationDisabledUntil() {
return communicationDisabledUntil;
}

@JsonProperty("communication_disabled_until")
public void setCommunicationDisabledUntil(Object communicationDisabledUntil) {
this.communicationDisabledUntil = communicationDisabledUntil;
}

@JsonProperty("avatar")
public Object getAvatar() {
return avatar;
}

@JsonProperty("avatar")
public void setAvatar(Object avatar) {
this.avatar = avatar;
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