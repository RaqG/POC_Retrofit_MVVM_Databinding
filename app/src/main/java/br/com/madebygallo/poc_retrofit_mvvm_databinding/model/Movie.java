package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by RaqGallo on 07/07/2018
 */

public class Movie extends BaseObservable implements Serializable {

    @Expose
    private String poster_path;
    @Expose
    private String overview;
    @Expose
    private int id;
    @Expose
    private String title;
    @Expose
    private float vote_average;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }
}
