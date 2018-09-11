package com.example.bryan.cabingameslist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CabinGamesModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("owner")
    @Expose
    private String owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
