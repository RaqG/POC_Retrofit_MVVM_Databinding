package br.com.madebygallo.poc_retrofit_mvvm_databinding.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

import br.com.madebygallo.poc_retrofit_mvvm_databinding.model.Genre;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.BASE_IMAGE_URL;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class BindingAdapterUtil {

    @BindingAdapter({"app:srcPopMovieImage"})
    public static void getPopMovieImageFromUrl(ImageView imageView, String imageUrl) {
        String imagePath = BASE_IMAGE_URL + imageUrl;
        Picasso.get()
                .load(imagePath)
                .error(android.R.drawable.stat_notify_error)
                .resize(100, 100)
                .into(imageView);
    }

    @BindingAdapter({"app:srcUpcomingImage"})
    public static void getUpcomingImageFromUrl(ImageView imageView, String imageUrl) {
        String imagePath = BASE_IMAGE_URL + imageUrl;

        Picasso.get()
                .load(imagePath)
                .resize(1030, 900)
                .into(imageView);
    }

    @BindingAdapter({"app:background"})
    public static void getBackgroundFromUri(ImageView layout, String path) {
        String image = BASE_IMAGE_URL + path;
        Picasso.get()
                .load(image)
                .error(android.R.drawable.stat_notify_error)
                .into(layout);
    }

    @BindingAdapter({"app:poster"})
    public static void getPosterFromUri(ImageView layout, String path) {
        String image = BASE_IMAGE_URL + path;
        Picasso.get()
                .load(image)
                .resize(550, 750)
                .into(layout);
    }

    @BindingAdapter(value = {"titleText", "dateText"})
    public static void getCustomMovieTitle(TextView textView, String title, String date) {
        if (title != null && date != null) {
            String year = date.substring(0, 4);
            textView.setText(title.concat(" (" + year + ")"));
        } else {
            textView.setText("");
        }
    }

    @BindingAdapter({"app:genresText"})
    public static void getAllGenres(TextView textView, List<Genre> genreList) {
        if (genreList != null) {
            for (Iterator<Genre> i = genreList.iterator(); i.hasNext(); ) {
                textView.append(i.next().getName());
                if (i.hasNext())
                    textView.append(" / ");
            }
        } else
            textView.setText("");
    }
}
