package br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.R;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.databinding.ItemUpcomingMovieBinding;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Movie;
import br.com.madebygallo.poc_retrofit_mvvm_databinding.ui.view.MovieDetailActivity;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.MOVIE;

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

    public void addAllOnList(List<Movie> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public class UpcomingMovieViewHolder extends RecyclerView.ViewHolder {

        ItemUpcomingMovieBinding binding;

        public UpcomingMovieViewHolder(ItemUpcomingMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            setOnClick(itemView);
        }

        public void bind(Movie movie) {
            binding.setUpcoming(movie);
            binding.executePendingBindings();
        }

        private void setOnClick(final View itemView) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(v.getContext(), MovieDetailActivity.class);
                    it.putExtra(MOVIE, binding.getUpcoming());
                    v.getContext().startActivity(it);
                }
            });
        }
    }
}
