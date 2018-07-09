package br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response;

import com.google.gson.annotations.Expose;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;

/**
 * Created by RaqGallo on 07/07/2018
 */

public class MovieResponse {

    @Expose
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
