package com.gdev.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.gdev.movieapp.adapters.GenresAdapter;
import com.gdev.movieapp.fragments.Genres;
import com.gdev.movieapp.fragments.Home;
import com.gdev.movieapp.fragments.Popular;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.new_movies);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Home()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.new_movies:
                    replaceFragment(new Home());
                    return true;
                case R.id.popular_movies:
                    replaceFragment(new Popular());
                    return true;
                case R.id.genres:
                    replaceFragment(new Genres());
                    return true;
            }

            return false;
        });
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}