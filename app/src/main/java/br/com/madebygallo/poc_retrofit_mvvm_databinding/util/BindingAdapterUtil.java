package br.com.madebygallo.poc_retrofit_mvvm_databinding.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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
}
