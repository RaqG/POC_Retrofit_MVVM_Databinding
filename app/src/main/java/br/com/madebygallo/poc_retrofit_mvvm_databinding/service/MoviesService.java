package br.com.madebygallo.poc_retrofit_mvvm_databinding.service;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RaqGallo on 07/07/2018
 */

public interface MoviesService {

    @GET("/3/movie/popular")
    Call<MovieResponse> getPopulars(@Query("api_key") String apiKey);

    @GET("/3/movie/upcoming")
    Call<MovieResponse> getUpcomings(@Query("api_key") String apiKey);
}
