package tech.hatsu.discord;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonDeserialize(using = DiscordEvent.class)
//@Builder
//@JsonDeserialize(as = DiscordEvent.class)

public class DiscordEvent {
    int op;
    Object d; // TODO Actually a JSON object
    int s;
    String t;

//    public DiscordEvent(int op, Object d) {
//        this.op = op;
//        this.d = d;
//    }

    public String getT() {
        return t;
    }

    public int getS() {
        return s;
    }

    public Object getD() {
        return d;
    }

    public int getOp() {
        return op;
    }

    public void setD(Object d) {
        this.d = d;
    }

    public void setS(int s) {
        this.s = s;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public void setT(String t) {
        this.t = t;
    }
}
