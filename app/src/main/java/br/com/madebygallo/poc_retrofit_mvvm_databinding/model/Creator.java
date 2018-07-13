package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import com.google.gson.annotations.Expose;

/**
 * Created by RaqGallo on 11/07/2018
 */

public class Creator {

    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String profile_path;

    public Creator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
