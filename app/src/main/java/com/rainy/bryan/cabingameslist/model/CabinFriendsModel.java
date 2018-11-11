package com.rainy.bryan.cabingameslist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CabinFriendsModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("cabins")
    @Expose
    private String cabins;
    @SerializedName("picture_id")
    @Expose
    private String pictureID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCabins() {
        return cabins;
    }

    public void setCabins(String cabins) {
        this.cabins = cabins;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }
}
