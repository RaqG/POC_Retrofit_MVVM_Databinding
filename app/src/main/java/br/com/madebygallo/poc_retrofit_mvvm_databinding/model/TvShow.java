package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by RaqGallo on 07/07/2018
 */

public class TvShow extends BaseObservable implements Serializable {

    @Expose
    private String original_name;
    @Expose
    private String first_air_date;
    @Expose
    private int id;
    @Expose
    private float vote_average;
    @Expose
    private String overview;
    @Expose
    private String poster_path;

    public TvShow() {
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
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
}
