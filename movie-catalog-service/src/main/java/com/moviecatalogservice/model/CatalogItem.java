package com.moviecatalogservice.model;


public class CatalogItem {

    private String movieName;
    private String desc;
    private Integer ratings;

    public CatalogItem(String movieName, String desc, Integer ratings) {
        this.movieName = movieName;
        this.desc = desc;
        this.ratings = ratings;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }



}
