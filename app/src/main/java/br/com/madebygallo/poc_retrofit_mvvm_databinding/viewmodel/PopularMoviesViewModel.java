package br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.MoviesService;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response.MovieResponse;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.API_KEY;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class PopularMoviesViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> getListMutableLiveData() {
        return listMutableLiveData;
    }


    public void init() {
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        MoviesService service = retrofitConfig.getMoviesService();
        initService(service);
    }

    private void initService(final MoviesService service) {
        service.getPopulars(API_KEY).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                listMutableLiveData.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                listMutableLiveData.setValue(null);
                initService(service);
            }
        });
    }
}
