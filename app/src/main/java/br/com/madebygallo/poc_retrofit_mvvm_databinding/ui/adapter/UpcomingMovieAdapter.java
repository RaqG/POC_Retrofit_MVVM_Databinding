package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ItemUpcomingMovieBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class UpcomingMovieAdapter extends RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMovieViewHolder> {

    List<Movie> movies;

    public UpcomingMovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public UpcomingMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUpcomingMovieBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_upcoming_movie, parent, false);
        return new UpcomingMovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingMovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class UpcomingMovieViewHolder extends RecyclerView.ViewHolder {

        ItemUpcomingMovieBinding binding;

        public UpcomingMovieViewHolder(ItemUpcomingMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movie movie) {
            binding.setUpcoming(movie);
            binding.executePendingBindings();
        }
    }
}
