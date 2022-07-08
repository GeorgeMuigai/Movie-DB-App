package com.gdev.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MovieApi {
    @GET("genre/movie/list?api_key=39c56d9594f0d22979d3d180187e140e&language=en-US")
    Call<GenresModal> getGenres();

    @GET("trending/all/day?api_key=39c56d9594f0d22979d3d180187e140e")
    Call<Results> getNewMovies();

    @GET("movie/popular?api_key=39c56d9594f0d22979d3d180187e140e&language=en-US&page=1")
    Call<Results> getPopular();

    @GET
    Call<SingleMovie> getMovieById(@Url String url);
}
