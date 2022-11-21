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
"username",
"public_flags",
"id",
"discriminator",
"bot",
"avatar"
})
@Generated("jsonschema2pojo")
public class User {

@JsonProperty("username")
private String username;
@JsonProperty("public_flags")
private int publicFlags;
@JsonProperty("id")
private String id;
@JsonProperty("discriminator")
private String discriminator;
@JsonProperty("bot")
private boolean bot;
@JsonProperty("avatar")
private String avatar;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("username")
public String getUsername() {
return username;
}

@JsonProperty("username")
public void setUsername(String username) {
this.username = username;
}

@JsonProperty("public_flags")
public int getPublicFlags() {
return publicFlags;
}

@JsonProperty("public_flags")
public void setPublicFlags(int publicFlags) {
this.publicFlags = publicFlags;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("discriminator")
public String getDiscriminator() {
return discriminator;
}

@JsonProperty("discriminator")
public void setDiscriminator(String discriminator) {
this.discriminator = discriminator;
}

@JsonProperty("bot")
public boolean isBot() {
return bot;
}

@JsonProperty("bot")
public void setBot(boolean bot) {
this.bot = bot;
}

@JsonProperty("avatar")
public String getAvatar() {
return avatar;
}

@JsonProperty("avatar")
public void setAvatar(String avatar) {
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