package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ActivityTvShowDetailBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Network;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShowDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.TvShowDetailViewModel;
import butterknife.BindView;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.BASE_IMAGE_URL;
import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.binding.BindingAdapterUtil.getPopMovieImageFromUrl;

/**
 * Created by RaqGallo on 11/07/2018
 */

public class TvShowDetailActivity extends AppCompatActivity {

    private TvShowDetailViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityTvShowDetailBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_tv_show_detail);
        viewModel = ViewModelProviders.of(this).get(TvShowDetailViewModel.class);

        viewModel.getTvShowDetailMutableLiveData().observe(this, new Observer<TvShowDetail>() {
            @Override
            public void onChanged(@Nullable TvShowDetail tvShowDetail) {
                binding.setTvShowDetail(tvShowDetail);
            }
        });

        viewModel.init(getIntent().getIntExtra("id", 0));
    }
}
