
package com.example.pancho.homeawaychallenge.entitites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("took")
    @Expose
    private Integer took;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("geolocation")
    @Expose
    private Object geolocation;
    @SerializedName("page")
    @Expose
    private Integer page;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTook() {
        return took;
    }

    public void setTook(Integer took) {
        this.took = took;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Object getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Object geolocation) {
        this.geolocation = geolocation;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
