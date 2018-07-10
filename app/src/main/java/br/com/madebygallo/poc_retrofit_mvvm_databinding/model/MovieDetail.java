package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by RaqGallo on 09/07/2018
 */

public class MovieDetail extends BaseObservable {

    @Expose
    private int id;
    @Expose
    private String title;
    @Expose
    private String overview;
    @Expose
    private String poster_path;
    @Expose
    private String release_date;
    @Expose
    private float vote_average;
    @Expose
    private List<Genre> genres;
    @Expose
    private String homepage;

    public MovieDetail() {
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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
