
package com.example.pancho.homeawaychallengue.entitites;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("extended_address")
    @Expose
    private String extendedAddress;
    @SerializedName("display_location")
    @Expose
    private String displayLocation;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("name_v2")
    @Expose
    private String nameV2;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private Location location;

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExtendedAddress() {
        return extendedAddress;
    }

    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNameV2() {
        return nameV2;
    }

    public void setNameV2(String nameV2) {
        this.nameV2 = nameV2;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
