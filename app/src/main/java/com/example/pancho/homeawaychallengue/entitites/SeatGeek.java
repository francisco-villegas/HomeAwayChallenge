
package com.example.pancho.homeawaychallengue.entitites;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeatGeek {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("in_hand")
    @Expose
    private InHand inHand;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public InHand getInHand() {
        return inHand;
    }

    public void setInHand(InHand inHand) {
        this.inHand = inHand;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
