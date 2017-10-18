
package com.example.pancho.homeawaychallengue.entitites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("huge")
    @Expose
    private String huge;

    public String getHuge() {
        return huge;
    }

    public void setHuge(String huge) {
        this.huge = huge;
    }

}
