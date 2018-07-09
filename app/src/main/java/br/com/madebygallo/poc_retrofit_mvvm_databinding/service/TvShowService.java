package br.com.madebygallo.poc_retrofit_mvvm_databinding.service;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response.TvShowResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RaqGallo on 07/07/2018
 */

public interface TvShowService {

    @GET("/3/tv/popular/")
    Call<TvShowResponse> getPopulars(@Query("api_key") String apiKey);
}
