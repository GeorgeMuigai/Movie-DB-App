package com.gdev.movieapp;

import com.google.gson.annotations.SerializedName;

public class MoviesList {
    @SerializedName("poster_path")
    String img_url;
    String title;

    public MoviesList(String img_url, String title) {
        this.img_url = img_url;
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getTitle() {
        return title;
    }
}
