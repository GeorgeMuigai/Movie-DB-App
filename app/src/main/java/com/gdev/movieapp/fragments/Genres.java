package com.gdev.movieapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gdev.movieapp.GenresList;
import com.gdev.movieapp.GenresModal;
import com.gdev.movieapp.R;
import com.gdev.movieapp.RetrofitClient;
import com.gdev.movieapp.adapters.GenresAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Genres extends Fragment {
    RecyclerView rv_genres;

    List<GenresList> genresList = new ArrayList<>();
    GenresAdapter adapter;

    public Genres() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genres, container, false);
        rv_genres = view.findViewById(R.id.rv_genres);

        adapter = new GenresAdapter(genresList);
        rv_genres.setAdapter(adapter);

        getAllGenres();
        return view;
    }

    private void getAllGenres() {
        Call<GenresModal> getGenres = RetrofitClient.getRetrofit().getApi().getGenres();
        getGenres.enqueue(new Callback<GenresModal>() {
            @Override
            public void onResponse(Call<GenresModal> call, Response<GenresModal> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getView().getContext(), "Error code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                GenresModal genresModal = response.body();
                ArrayList<GenresList> genres = genresModal.getGenresList();

                for (int i = 0; i < genres.size(); i++) {
                    genresList.add(new GenresList(genres.get(i).getId(), genres.get(i).getName()));
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GenresModal> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}