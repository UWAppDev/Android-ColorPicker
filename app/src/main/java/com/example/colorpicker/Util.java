package com.example.colorpicker;

import android.content.res.Resources;
import android.util.DisplayMetrics;

class Util {

    private Util() {

    }

    static int convertDpToPx(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp*((float)metrics.densityDpi/160.0f);
        return Math.round(px);
    }

}
