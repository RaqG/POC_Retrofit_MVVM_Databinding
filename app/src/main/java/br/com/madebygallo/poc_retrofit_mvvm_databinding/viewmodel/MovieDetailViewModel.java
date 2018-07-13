package br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.MovieDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.MoviesService;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.API_KEY;

/**
 * Created by RaqGallo on 09/07/2018
 */

public class MovieDetailViewModel extends ViewModel {

    private MutableLiveData<MovieDetail> movieDetail = new MutableLiveData<>();

    public MutableLiveData<MovieDetail> getMovieDetail() {
        return movieDetail;
    }

    public void init(int movieId) {
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        MoviesService service = retrofitConfig.getMoviesService();
        initService(service, movieId);
    }

    private void initService(final MoviesService service, final int movieId) {
        service.getDetail(movieId, API_KEY).enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                movieDetail.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                movieDetail.setValue(null);
                initService(service, movieId);
            }
        });
    }
}
