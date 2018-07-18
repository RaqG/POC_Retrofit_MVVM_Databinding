package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pchmn.materialchips.ChipView;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ActivityTvShowDetailBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Creator;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Genre;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShowDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.TvShowDetailViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.BASE_IMAGE_URL;

/**
 * Created by RaqGallo on 11/07/2018
 */

public class TvShowDetailActivity extends AppCompatActivity {

    private TvShowDetailViewModel viewModel;
    private LinearLayout linearLayout;
    private LinearLayout.LayoutParams params;
    private TextView creatorName;
    private ImageView creatorImgProfile;

    @BindView(R.id.constraint_layout_tv_show_detail)
    ConstraintLayout constraintLayout;

    @BindView(R.id.progress_bar_tv_show_detail)
    ProgressBar progressBar;

    @BindView(R.id.chips_layout)
    LinearLayout chipLayout;

    @BindView(R.id.content_tv_show_creator)
    GridLayout gridLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityTvShowDetailBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_tv_show_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        constraintLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        viewModel = ViewModelProviders.of(this).get(TvShowDetailViewModel.class);

        viewModel.getTvShowDetailMutableLiveData().observe(this, new Observer<TvShowDetail>() {
            @Override
            public void onChanged(@Nullable TvShowDetail tvShowDetail) {
                binding.setTvShowDetail(tvShowDetail);
                if (tvShowDetail != null) {
                    showGenres(tvShowDetail.getGenres());
                    showCreators(tvShowDetail.getCreated_by());
                    constraintLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        viewModel.init(getIntent().getIntExtra("id", 0));
    }

    private void showCreators(List<Creator> creators) {
        if (creators != null) {
            int total = creators.size();
            int column = 2;
            int row = total / column;
            gridLayout.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
            gridLayout.setRowCount(row == 0 ? row + 1 : row);
            gridLayout.setColumnCount(column);


            for (int i = 0; i < total; i++) {
                Creator currentCreator = creators.get(i);
                setLinearLayoutParams();
                setTextValueAndProperties(currentCreator.getName());
                setImageValueAndProperties(currentCreator.getProfile_path());

                linearLayout.addView(creatorImgProfile);
                linearLayout.addView(creatorName);

                gridLayout.addView(linearLayout, i);
            }
        }
    }

    private void setTextValueAndProperties(String name) {
        creatorName = new TextView(this);
        creatorName.setText(name);
        creatorName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
        creatorName.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        creatorName.setTextColor(ContextCompat.getColor(this, R.color.colorIcons));
        creatorName.setGravity(Gravity.CENTER);
        creatorName.setPadding(0, 16, 0, 0);
    }

    private void setImageValueAndProperties(String path) {
        creatorImgProfile = new ImageView(this);
        setImageFromUri(path);
        creatorImgProfile.setLayoutParams(params);
    }

    private void setLinearLayoutParams() {
        linearLayout = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        params.rightMargin = 16;
        params.leftMargin = 16;
        params.topMargin = 32;
    }

    private void setImageFromUri(String profile_path) {
        Picasso.get()
                .load(BASE_IMAGE_URL + profile_path)
                .error(R.drawable.ic_account_circle_white)
                .into(creatorImgProfile);
    }

    private void showGenres(List<Genre> genres) {
        for (int i = 0; i < genres.size(); i++) {
            chipLayout.addView(setChipAttributes(genres.get(i)));
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
