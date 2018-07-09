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
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter.PopMovieAdapter;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.PopularMoviesViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class PopularMoviesTab extends Fragment {
    private PopularMoviesViewModel viewModel;

    private RecyclerView.Adapter adapter;
    private LinearLayoutManager manager;

    @BindView(R.id.popular_movie_recycler_view)
    RecyclerView recyclerView;

    public PopularMoviesTab() {
    }

    public static PopularMoviesTab newInstance() {
        return new PopularMoviesTab();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_movies_tab, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        viewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel.class);
        viewModel.getListMutableLiveData().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                if (movies != null) {
                    adapter = new PopMovieAdapter(movies);
                    recyclerView.setAdapter(adapter);
                }
            }
        });

        viewModel.init();

    }
}
