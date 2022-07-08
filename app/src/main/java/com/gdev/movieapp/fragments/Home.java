package com.gdev.movieapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.gdev.movieapp.MoviesList;
import com.gdev.movieapp.R;
import com.gdev.movieapp.Results;
import com.gdev.movieapp.RetrofitClient;
import com.gdev.movieapp.adapters.NewMoviesAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {

    RecyclerView rv_new_movies;
    NewMoviesAdapter adapter;
    List<MoviesList> moviesList;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        adapter = new NewMoviesAdapter(moviesList);
        rv_new_movies = view.findViewById(R.id.rv_new_movies);
        rv_new_movies.setAdapter(adapter);

        getNewMovies();
        return view;
    }

    private void getNewMovies() {
        Call<Results> getNewMovies = RetrofitClient.getRetrofit().getApi().getNewMovies();

        getNewMovies.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Error code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                Results results = response.body();
                ArrayList<MoviesList> movies = results.getResults();

                for (int i = 0; i < movies.size(); i++) {
                    moviesList.add(new MoviesList(movies.get(i).getImg_url(), movies.get(i).getTitle()));
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}