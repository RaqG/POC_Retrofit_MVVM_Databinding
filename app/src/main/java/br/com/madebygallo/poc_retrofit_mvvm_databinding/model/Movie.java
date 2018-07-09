package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;

/**
 * Created by RaqGallo on 07/07/2018
 */

public class Movie extends BaseObservable {

    @Expose
    private String poster_path;
    @Expose
    private String overview;
    @Expose
    private String release_date;
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

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
