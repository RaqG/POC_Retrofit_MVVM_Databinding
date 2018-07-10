package br.com.madebygallo.poc_retrofit_mvvm_databinding.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;

/**
 * Created by RaqGallo on 09/07/2018
 */

public class Genre extends BaseObservable {

    @Expose
    private int id;
    @Expose
    private String name;

    public Genre() {
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
}
