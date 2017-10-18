
package com.example.pancho.homeawaychallenge.entitites;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Performer implements Parcelable{

    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy_> taxonomies = null;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_license")
    @Expose
    private Object imageLicense;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("divisions")
    @Expose
    private Object divisions;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("colors")
    @Expose
    private Object colors;
    @SerializedName("home_venue_id")
    @Expose
    private Object homeVenueId;
    @SerializedName("image_attribution")
    @Expose
    private String imageAttribution;
    @SerializedName("id")
    @Expose
    private Integer id;

    protected Performer(Parcel in) {
        image = in.readString();
        name = in.readString();
        slug = in.readString();
        shortName = in.readString();
        type = in.readString();
        url = in.readString();
        imageAttribution = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(slug);
        dest.writeString(shortName);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeString(imageAttribution);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Performer> CREATOR = new Creator<Performer>() {
        @Override
        public Performer createFromParcel(Parcel in) {
            return new Performer(in);
        }

        @Override
        public Performer[] newArray(int size) {
            return new Performer[size];
        }
    };

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public List<Taxonomy_> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy_> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getImageLicense() {
        return imageLicense;
    }

    public void setImageLicense(Object imageLicense) {
        this.imageLicense = imageLicense;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Object getDivisions() {
        return divisions;
    }

    public void setDivisions(Object divisions) {
        this.divisions = divisions;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public Object getColors() {
        return colors;
    }

    public void setColors(Object colors) {
        this.colors = colors;
    }

    public Object getHomeVenueId() {
        return homeVenueId;
    }

    public void setHomeVenueId(Object homeVenueId) {
        this.homeVenueId = homeVenueId;
    }

    public String getImageAttribution() {
        return imageAttribution;
    }

    public void setImageAttribution(String imageAttribution) {
        this.imageAttribution = imageAttribution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
