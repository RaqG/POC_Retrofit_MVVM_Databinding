package br.com.madebygallo.poc_retrofit_mvvm_databinding.service;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.MovieDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by RaqGallo on 10/07/2018
 */

public interface MovieDetailService {

    @GET("/3/movie/{movie_id}")
    Call<MovieDetail> getDetail(@Path("movie_id") int id, @Query("api_key") String apiKey);
}
