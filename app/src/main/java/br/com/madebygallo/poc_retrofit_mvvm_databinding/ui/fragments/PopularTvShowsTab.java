package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShow;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter.PopTvShowAdapter;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.util.EndlessScrollListener;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.viewmodel.PopularTvShowViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class PopularTvShowsTab extends Fragment {

    PopularTvShowViewModel viewModel;
    private GridLayoutManager manager;
    private PopTvShowAdapter adapter;

    @BindView(R.id.pop_tv_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.pop_tv_serie_progress_bar)
    ProgressBar progressBar;

    public PopularTvShowsTab() {
    }

    public static PopularTvShowsTab newInstance() {
        PopularTvShowsTab fragment = new PopularTvShowsTab();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_tv_shows_tab, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PopularTvShowViewModel.class);
        viewModel.listMutableLiveData.observe(this, new Observer<List<TvShow>>() {
            @Override
            public void onChanged(@Nullable List<TvShow> tvShows) {
                if (tvShows == null)
                    return;

                progressBar.setVisibility(View.GONE);
                adapter.AddAllOnList(tvShows);

            }
        });
        viewModel.init(1);
        setupCustomAdapter(new ArrayList<TvShow>());
    }

    private void setupCustomAdapter(List<TvShow> tvShows) {
        manager = new GridLayoutManager(getActivity(),
                2,
                GridLayoutManager.VERTICAL,
                false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(manager);
        adapter = new PopTvShowAdapter(tvShows);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new EndlessScrollListener(manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                viewModel.loadMore(++page);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}
