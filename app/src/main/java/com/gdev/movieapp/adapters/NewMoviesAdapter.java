package com.gdev.movieapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gdev.movieapp.MoviesList;
import com.gdev.movieapp.R;
import com.gdev.movieapp.Results;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewMoviesAdapter extends RecyclerView.Adapter<NewMoviesAdapter.ViewHolder> {
    List<MoviesList> results;

    public NewMoviesAdapter(List<MoviesList> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public NewMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_movies_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewMoviesAdapter.ViewHolder holder, int position) {
        MoviesList movie = results.get(position);
        try {
        Picasso.get().load("http://image.tmdb.org/t/p/w500" + movie.getImg_url()).into(holder.img_new_movie);
        }catch (Exception e){
            Toast.makeText(holder.itemView.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        holder.txt_new_movie.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_new_movie;
        TextView txt_new_movie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_new_movie = itemView.findViewById(R.id.img_new_movie_poster);
            txt_new_movie = itemView.findViewById(R.id.txt_new_movie_title);
        }
    }
}
