
package com.example.pancho.homeawaychallenge.entitites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats_ {

    @SerializedName("average_price")
    @Expose
    private Object averagePrice;
    @SerializedName("lowest_price_good_deals")
    @Expose
    private Object lowestPriceGoodDeals;
    @SerializedName("listing_count")
    @Expose
    private Object listingCount;
    @SerializedName("highest_price")
    @Expose
    private Object highestPrice;
    @SerializedName("lowest_price")
    @Expose
    private Object lowestPrice;

    public Object getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Object averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Object getLowestPriceGoodDeals() {
        return lowestPriceGoodDeals;
    }

    public void setLowestPriceGoodDeals(Object lowestPriceGoodDeals) {
        this.lowestPriceGoodDeals = lowestPriceGoodDeals;
    }

    public Object getListingCount() {
        return listingCount;
    }

    public void setListingCount(Object listingCount) {
        this.listingCount = listingCount;
    }

    public Object getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Object highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Object getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Object lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

}
