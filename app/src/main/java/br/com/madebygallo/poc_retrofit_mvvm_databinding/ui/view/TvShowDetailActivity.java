package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.pchmn.materialchips.ChipView;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ActivityTvShowDetailBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Genre;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShowDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.TvShowDetailViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RaqGallo on 11/07/2018
 */

public class TvShowDetailActivity extends AppCompatActivity {

    private TvShowDetailViewModel viewModel;

    @BindView(R.id.chips_layout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityTvShowDetailBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_tv_show_detail);
        ButterKnife.bind(this);
        viewModel = ViewModelProviders.of(this).get(TvShowDetailViewModel.class);

        viewModel.getTvShowDetailMutableLiveData().observe(this, new Observer<TvShowDetail>() {
            @Override
            public void onChanged(@Nullable TvShowDetail tvShowDetail) {
                binding.setTvShowDetail(tvShowDetail);
                if (tvShowDetail != null)
                    showGenres(tvShowDetail.getGenres());
            }
        });

        viewModel.init(getIntent().getIntExtra("id", 0));
    }

    private void showGenres(List<Genre> genres) {
        for (int i = 0; i < genres.size(); i++) {
            linearLayout.addView(setChipAttributes(genres.get(i)));
        }
    }

    private ChipView setChipAttributes(Genre genre) {
        ChipView chipView = new ChipView(this);
        chipView.setDeletable(false);
        chipView.setHasAvatarIcon(false);
        chipView.setLabel(genre.getName());
        chipView.setChipBackgroundColor(ContextCompat.getColor(getApplication(), R.color.colorPrimary));
        chipView.setLabelColor(ContextCompat.getColor(getApplication(), R.color.colorIcons));
        chipView.setPadding(0, 0, 16, 0);

        return chipView;
    }
}
