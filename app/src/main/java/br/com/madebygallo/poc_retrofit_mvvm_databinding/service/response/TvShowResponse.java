package br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response;

import com.google.gson.annotations.Expose;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShow;

/**
 * Created by RaqGallo on 07/07/2018
 */

public class TvShowResponse {

    @Expose
    public List<TvShow> results;

    public List<TvShow> getResults() {
        return results;
    }

    public void setResults(List<TvShow> results) {
        this.results = results;
    }
}
