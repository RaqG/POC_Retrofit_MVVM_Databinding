package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import com.google.gson.annotations.Expose;

/**
 * Created by RaqGallo on 11/07/2018
 */

public class Network {

    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String logo_path;

    public Network() {
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

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }
}
