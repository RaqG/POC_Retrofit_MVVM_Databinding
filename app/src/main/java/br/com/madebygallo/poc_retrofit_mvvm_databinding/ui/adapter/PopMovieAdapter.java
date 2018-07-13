package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ItemPopularMovieBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view.MovieDetailActivity;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.MOVIE;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class PopMovieAdapter extends RecyclerView.Adapter<PopMovieAdapter.PopMovieViewHolder> {

    List<Movie> movieList;

    public PopMovieAdapter(List<Movie> movies) {
        this.movieList = movies;
    }

    @NonNull
    @Override
    public PopMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPopularMovieBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_popular_movie, parent, false);
        return new PopMovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopMovieViewHolder holder, int position) {
        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void addAllOnList(List<Movie> movies) {
        this.movieList.addAll(movies);
        notifyDataSetChanged();
    }

    public class PopMovieViewHolder extends RecyclerView.ViewHolder {

        ItemPopularMovieBinding binding;

        public PopMovieViewHolder(ItemPopularMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            setOnItemClick(itemView);
        }

        public void bind(Movie movie) {
            binding.setPopMovie(movie);
            binding.executePendingBindings();
        }

        private void setOnItemClick(View itemView) {
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent it = new Intent(view.getContext(), MovieDetailActivity.class);
                    it.putExtra(MOVIE, binding.getPopMovie());
                    view.getContext().startActivity(it);
                }
            });
        }
    }
}

