package br.com.madebygallo.poc_retrofit_mvvm_databinding.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static br.com.madebygallo.poc_retrofit_mvvm_databinding.util.ConstantsUtil.BASE_IMAGE_URL;

/**
 * Created by RaqGallo on 08/07/2018
 */

public class BindingAdapter {

    @android.databinding.BindingAdapter({"app:srcPopMovieImage"})
    public static void getPopMovieImageFromUrl(ImageView imageView, String imageUrl) {
        String imagePath = BASE_IMAGE_URL + imageUrl;
        Picasso.get()
                .load(imagePath)
                .error(android.R.drawable.stat_notify_error)
                .resize(100, 100)
                .into(imageView);
    }
}
