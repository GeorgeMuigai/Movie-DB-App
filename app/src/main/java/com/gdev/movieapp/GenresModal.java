package com.gdev.movieapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GenresModal {
    @SerializedName("genres")
    ArrayList<GenresList> genresList;

    public GenresModal(ArrayList<GenresList> genresList) {
        this.genresList = genresList;
    }

    public ArrayList<GenresList> getGenresList() {
        return genresList;
    }
}
