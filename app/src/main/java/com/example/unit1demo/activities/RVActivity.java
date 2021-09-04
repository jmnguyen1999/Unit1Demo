package com.example.unit1demo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.unit1demo.adapters.MovieAdapter;
import com.example.unit1demo.R;
import com.example.unit1demo.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {

    RecyclerView rvItems;
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);

        rvItems = findViewById(R.id.rvItems);

        //Needs 3 things: Data to populate (models), Adapter (how is each model displayed?), LayoutManager (How are models displayed in relation to each other?)
        //1.) Models to populate:
        movies = new ArrayList<>();
        movies.add(new Movie("Title 1" ,"url1"));
        movies.add(new Movie("Title 2" ,"url2"));
        movies.add(new Movie("Title 3" ,"url3"));
        movies.add(new Movie("Title 4" ,"url4"));
        movies.add(new Movie("Title 5" ,"url5"));
        movies.add(new Movie("Title 6" ,"url6"));
        movies.add(new Movie("Title 7" ,"url7"));
        movies.add(new Movie("Title 8" ,"url8"));


        //2.) An Adapter:
        MovieAdapter movieAdapter = new MovieAdapter(this, movies);
        rvItems.setAdapter(movieAdapter);


        //3.) LayoutManager:
        rvItems.setLayoutManager(new LinearLayoutManager(this));


    }
}