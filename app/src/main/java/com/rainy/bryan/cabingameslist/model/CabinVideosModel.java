package com.rainy.bryan.cabingameslist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CabinVideosModel {

    @SerializedName("year")
    @Expose
    private String videoYear;
    @SerializedName("title")
    @Expose
    private String videoTitle;
    @SerializedName("video_id")
    @Expose
    private String videoID;
    @SerializedName("picture_id")
    @Expose
    private String pictureID;

    public String getVideoYear() {
        return videoYear;
    }

    public void setVideoYear(String videoYear) {
        this.videoYear = videoYear;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getPictureID() {
        return pictureID;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }



}
