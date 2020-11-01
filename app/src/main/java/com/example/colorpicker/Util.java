package com.example.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Toast;

class Util {

    private Util() {

    }

    static int convertDpToPx(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp*((float)metrics.densityDpi/160.0f);
        return Math.round(px);
    }

    static Toast toast(Context context, Toast oldToast, String text, int length) {
        if (oldToast != null) {
            oldToast.cancel();
        }
        Toast toast = Toast.makeText(context, text, length);
        toast.show();
        return toast;
    }

}
