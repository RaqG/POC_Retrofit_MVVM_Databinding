package br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShowDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.service.TvShowService;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.API_KEY;

/**
 * Created by RaqGallo on 12/07/2018
 */

public class TvShowDetailViewModel extends ViewModel {

    MutableLiveData<TvShowDetail> tvShowDetailMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<TvShowDetail> getTvShowDetailMutableLiveData() {
        return tvShowDetailMutableLiveData;
    }

    public void init(int id) {
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        TvShowService service = retrofitConfig.getTvShowService();
        initService(service, id);
    }

    private void initService(final TvShowService service, final int id) {
        service.getTvShowDetail(id, API_KEY).enqueue(new Callback<TvShowDetail>() {
            @Override
            public void onResponse(Call<TvShowDetail> call, Response<TvShowDetail> response) {
                tvShowDetailMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TvShowDetail> call, Throwable t) {
                tvShowDetailMutableLiveData.setValue(null);
                initService(service, id);
            }
        });
    }
}
