package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ActivityMovieDetailBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.MovieDetail;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.MovieDetailViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.MOVIE;

/**
 * Created by RaqGallo on 09/07/2018
 */

public class MovieDetailActivity extends AppCompatActivity {

    private MovieDetailViewModel viewModel;

    @BindView(R.id.constraint_layout)
    ConstraintLayout layout;

    @BindView(R.id.movie_detail_progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMovieDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        layout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        Movie movie = (Movie) getIntent().getSerializableExtra(MOVIE);
        viewModel = ViewModelProviders.of(this).get(MovieDetailViewModel.class);
        viewModel.init(movie.getId());

        getSupportActionBar().setTitle(movie.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewModel.getMovieDetail().observe(this, new Observer<MovieDetail>() {
            @Override
            public void onChanged(@Nullable MovieDetail movieDetail) {
                if (movieDetail != null) {
                    progressBar.setVisibility(View.GONE);
                    layout.setVisibility(View.VISIBLE);
                }
                binding.setPopMovie(movieDetail);
            }
        });
    }
}
