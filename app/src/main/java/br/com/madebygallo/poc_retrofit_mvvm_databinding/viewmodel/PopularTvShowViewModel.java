package br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShow;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.TvShowService;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.response.TvShowResponse;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.API_KEY;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class PopularTvShowViewModel extends ViewModel {
    public MutableLiveData<List<TvShow>> listMutableLiveData = new MutableLiveData<>();

    public PopularTvShowViewModel() {
    }

    public void init(int page) {
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        TvShowService service = retrofitConfig.getTvShowService();
        initService(service, page);
    }

    private void initService(final TvShowService service, final int page) {
        service.getPopulars(API_KEY, page).enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                listMutableLiveData.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                listMutableLiveData.setValue(null);
                initService(service, page);
            }
        });
    }

    public void loadMore(int page) {
        init(page);
    }
}
