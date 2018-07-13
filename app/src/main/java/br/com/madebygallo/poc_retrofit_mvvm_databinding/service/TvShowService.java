package br.com.madebygallo.poc_retrofit_mvvm_databinding.service;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShowDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response.TvShowResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by RaqGallo on 07/07/2018
 */

public interface TvShowService {

    @GET("/3/tv/popular/")
    Call<TvShowResponse> getPopulars(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/tv/{tv_id}")
    Call<TvShowDetail> getTvShowDetail(@Path("tv_id") int id, @Query("api_key") String apiKey);
}
