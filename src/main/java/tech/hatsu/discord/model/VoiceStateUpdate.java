package tech.hatsu.discord.model;

import java.util.HashMap;
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
"member",
"user_id",
"suppress",
"session_id",
"self_video",
"self_mute",
"self_deaf",
"request_to_speak_timestamp",
"mute",
"guild_id",
"deaf",
"channel_id"
})
@Generated("jsonschema2pojo")
public class VoiceStateUpdate {

@JsonProperty("member")
private Member member;
@JsonProperty("user_id")
private String userId;
@JsonProperty("suppress")
private boolean suppress;
@JsonProperty("session_id")
private String sessionId;
@JsonProperty("self_video")
private boolean selfVideo;
@JsonProperty("self_mute")
private boolean selfMute;
@JsonProperty("self_deaf")
private boolean selfDeaf;
@JsonProperty("request_to_speak_timestamp")
private Object requestToSpeakTimestamp;
@JsonProperty("mute")
private boolean mute;
@JsonProperty("guild_id")
private String guildId;
@JsonProperty("deaf")
private boolean deaf;
@JsonProperty("channel_id")
private String channelId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("member")
public Member getMember() {
return member;
}

@JsonProperty("member")
public void setMember(Member member) {
this.member = member;
}

@JsonProperty("user_id")
public String getUserId() {
return userId;
}

@JsonProperty("user_id")
public void setUserId(String userId) {
this.userId = userId;
}

@JsonProperty("suppress")
public boolean isSuppress() {
return suppress;
}

@JsonProperty("suppress")
public void setSuppress(boolean suppress) {
this.suppress = suppress;
}

@JsonProperty("session_id")
public String getSessionId() {
return sessionId;
}

@JsonProperty("session_id")
public void setSessionId(String sessionId) {
this.sessionId = sessionId;
}

@JsonProperty("self_video")
public boolean isSelfVideo() {
return selfVideo;
}

@JsonProperty("self_video")
public void setSelfVideo(boolean selfVideo) {
this.selfVideo = selfVideo;
}

@JsonProperty("self_mute")
public boolean isSelfMute() {
return selfMute;
}

@JsonProperty("self_mute")
public void setSelfMute(boolean selfMute) {
this.selfMute = selfMute;
}

@JsonProperty("self_deaf")
public boolean isSelfDeaf() {
return selfDeaf;
}

@JsonProperty("self_deaf")
public void setSelfDeaf(boolean selfDeaf) {
this.selfDeaf = selfDeaf;
}

@JsonProperty("request_to_speak_timestamp")
public Object getRequestToSpeakTimestamp() {
return requestToSpeakTimestamp;
}

@JsonProperty("request_to_speak_timestamp")
public void setRequestToSpeakTimestamp(Object requestToSpeakTimestamp) {
this.requestToSpeakTimestamp = requestToSpeakTimestamp;
}

@JsonProperty("mute")
public boolean isMute() {
return mute;
}

@JsonProperty("mute")
public void setMute(boolean mute) {
this.mute = mute;
}

@JsonProperty("guild_id")
public String getGuildId() {
return guildId;
}

@JsonProperty("guild_id")
public void setGuildId(String guildId) {
this.guildId = guildId;
}

@JsonProperty("deaf")
public boolean isDeaf() {
return deaf;
}

@JsonProperty("deaf")
public void setDeaf(boolean deaf) {
this.deaf = deaf;
}

@JsonProperty("channel_id")
public String getChannelId() {
return channelId;
}

@JsonProperty("channel_id")
public void setChannelId(String channelId) {
this.channelId = channelId;
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