package com.gdev.movieapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static volatile RetrofitClient instance = null;
    private MovieApi api;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build();
        api = retrofit.create(MovieApi.class);
    }

    public static RetrofitClient getRetrofit() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    public MovieApi getApi(){
        return api;
    }
}
