package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ItemPopularTvShowBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.TvShow;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class PopTvShowAdapter extends RecyclerView.Adapter<PopTvShowAdapter.PopTvShowViewHolder> {

    List<TvShow> tvShows;

    public PopTvShowAdapter(List<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    @NonNull
    @Override
    public PopTvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPopularTvShowBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_popular_tv_show, parent, false);
        return new PopTvShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopTvShowViewHolder holder, int position) {
        holder.bind(tvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public void AddAllOnList(List<TvShow> tvShows) {
        this.tvShows.addAll(tvShows);
        notifyDataSetChanged();
    }

    public class PopTvShowViewHolder extends RecyclerView.ViewHolder {

        ItemPopularTvShowBinding binding;

        public PopTvShowViewHolder(ItemPopularTvShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(TvShow tvShow) {
            binding.setTvShow(tvShow);
            binding.executePendingBindings();
        }
    }
}
