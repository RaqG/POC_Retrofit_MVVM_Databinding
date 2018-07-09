package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter.UpcomingMovieAdapter;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.UpcomingMoviesViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class UpcomingMoviesTab extends Fragment {

    @BindView(R.id.upcoming_movie_recycler_view)
    RecyclerView recyclerView;

    private UpcomingMoviesViewModel viewModel;

    public UpcomingMoviesTab() {
    }

    public static UpcomingMoviesTab newInstance() {
        return new UpcomingMoviesTab();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_movies_tab, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(UpcomingMoviesViewModel.class);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        viewModel.getListMutableLiveData().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                UpcomingMovieAdapter adapter = new UpcomingMovieAdapter(movies);
                recyclerView.setAdapter(adapter);
            }
        });
        viewModel.init();
    }
}
