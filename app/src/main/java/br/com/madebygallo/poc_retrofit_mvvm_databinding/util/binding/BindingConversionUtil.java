package br.com.madebygallo.poc_retrofit_mvvm_databinding.util.binding;

import android.databinding.BindingConversion;
import android.databinding.InverseMethod;

/**
 * Created by RaqGallo on 10/07/2018
 */

public class BindingConversionUtil {

    @BindingConversion
    @InverseMethod("floatToString")
    public static float stringToFloat(String txtAverage) {
        return Float.parseFloat(txtAverage);
    }

    public static String floatToString(float average) {
        return String.valueOf(average);
    }
}
