package com.gdev.movieapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gdev.movieapp.GenresList;
import com.gdev.movieapp.R;

import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {
    List<GenresList> genresList;

    public GenresAdapter(List<GenresList> genresList) {
        this.genresList = genresList;
    }


    @NonNull
    @Override
    public GenresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.genres_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenresAdapter.ViewHolder holder, int position) {
        holder.txt_genre.setText(genresList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genresList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_genre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_genre = itemView.findViewById(R.id.txt_genre);
        }
    }
}
