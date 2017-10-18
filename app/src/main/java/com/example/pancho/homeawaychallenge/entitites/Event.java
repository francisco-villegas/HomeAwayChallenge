
package com.example.pancho.homeawaychallenge.entitites;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event implements Parcelable {

    @SerializedName("date_tbd")
    @Expose
    private Boolean dateTbd;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy> taxonomies = null;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("datetime_utc")
    @Expose
    private String datetimeUtc;
    @SerializedName("visible_until_utc")
    @Expose
    private String visibleUntilUtc;
    @SerializedName("performers")
    @Expose
    private List<Performer> performers = null;
    @SerializedName("time_tbd")
    @Expose
    private Boolean timeTbd;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("stats")
    @Expose
    private Stats_ stats;
    @SerializedName("datetime_tbd")
    @Expose
    private Boolean datetimeTbd;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("announce_date")
    @Expose
    private String announceDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("datetime_local")
    @Expose
    private String datetimeLocal;
    @SerializedName("short_title")
    @Expose
    private String shortTitle;

    protected Event(Parcel in) {
        venue = in.readParcelable(Venue.class.getClassLoader());
        datetimeUtc = in.readString();
        visibleUntilUtc = in.readString();
        performers = in.createTypedArrayList(Performer.CREATOR);
        title = in.readString();
        type = in.readString();
        url = in.readString();
        announceDate = in.readString();
        createdAt = in.readString();
        id = in.readString();
        datetimeLocal = in.readString();
        shortTitle = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(venue, flags);
        dest.writeString(datetimeUtc);
        dest.writeString(visibleUntilUtc);
        dest.writeTypedList(performers);
        dest.writeString(title);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeString(announceDate);
        dest.writeString(createdAt);
        dest.writeString(id);
        dest.writeString(datetimeLocal);
        dest.writeString(shortTitle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public Boolean getDateTbd() {
        return dateTbd;
    }

    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public Boolean getTimeTbd() {
        return timeTbd;
    }

    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Stats_ getStats() {
        return stats;
    }

    public void setStats(Stats_ stats) {
        this.stats = stats;
    }

    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }
}
