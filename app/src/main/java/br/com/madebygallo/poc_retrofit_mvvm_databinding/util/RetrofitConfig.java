package br.com.madebygallo.poc_retrofit_mvvm_databinding.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.MoviesService;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.TvShowService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RaqGallo on 07/07/2018
 */

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsUtil.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttpClient())
                .build();
    }

    public MoviesService getMoviesService() {
        return this.retrofit.create(MoviesService.class);
    }

    public TvShowService getTvShowService() {
        return this.retrofit.create(TvShowService.class);
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3, TimeUnit.SECONDS);
        builder.readTimeout(3, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }
}
