package com.example.unit1demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unit1demo.R;
import com.example.unit1demo.models.Movie;

import java.util.List;


//Gives each Movie the layout of item_movie:
//RecyclerView gives us a row, --> we figure out what to put into the row!
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context activity;
    List<Movie> movies;

    //Constructor --> gives the adapter what list of Movies to populate?
    public MovieAdapter(Context activity, List<Movie> movies){
        this.activity = activity;
        this.movies = movies;
    }


    @NonNull
    @Override
    //Purpose:      Inflates the row to look like item_movie.xml
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //Purpose:      Populate actual data into the item_movie.xml
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movieToShow = movies.get(position);
        holder.bind(movieToShow);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    //Purpose:         Determines exactly how the Movie is displayed in item_movie. E.g. Which Strings go in which TextViews? When Images go where? What Buttons do what?
    // I know what data to put into the row, but exactly what data goes where?
    public class ViewHolder extends RecyclerView.ViewHolder {

        //Views in item_movie
        TextView tvTitle;
        TextView tvURL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvURL = itemView.findViewById(R.id.tvUrl);
        }

        public void bind(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvURL.setText(movie.getImageUrl());
        }
    }
}
