package br.com.madebygallo.poc_retrofit_mvvm_databinding.service;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.MovieDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by RaqGallo on 07/07/2018
 */

public interface MoviesService {

    @GET("/3/movie/popular")
    Call<MovieResponse> getPopulars(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/upcoming")
    Call<MovieResponse> getUpcomings(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/{movie_id}")
    Call<MovieDetail> getDetail(@Path("movie_id") int id, @Query("api_key") String apiKey);
}
