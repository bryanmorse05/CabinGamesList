package com.example.bryan.cabingameslist.model;

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
    private String videoURL;
    @SerializedName("picture_id")
    @Expose
    private String pictureURL;

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

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }



}
