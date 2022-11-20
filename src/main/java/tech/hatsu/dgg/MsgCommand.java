package tech.hatsu.dgg;

import java.util.List;

public class MsgCommand {
    private String nick;
    private List<String> features;
    private long timestamp;
    private String data;

    public String getNick() {
        return nick;
    }

    public List<String> getFeatures() {
        return features;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }
}
