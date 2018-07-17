package com.liuleshuai.playandroid.utils;

import android.app.Activity;
import android.support.annotation.IntRange;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    /**
     * 默认位置吐司
     *
     * @param activity
     * @param msg
     */
    public static void show(Activity activity, String msg) {
        show(activity, msg, Gravity.NO_GRAVITY);
    }


    public static void show(Activity activity, String msg, int gravity) {
        show(activity, msg, gravity, Toast.LENGTH_SHORT);
    }

    public static void show(Activity activity, String msg, int gravity, @IntRange(from = 0, to = 1) int time) {
        toast = new Toast(activity);
        toast.setText(msg);
        if (time == 0) {
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }

}
