package com.example.unit1demo.models;

public class Movie {
    String title;
    String imageUrl;

    public Movie(String title, String imageUrl){
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle(){
        return title;
    }
    public String getImageUrl(){
        return imageUrl;
    }
}
