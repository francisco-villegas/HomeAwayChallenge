
package com.example.pancho.homeawaychallengue.entitites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taxonomy_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
