package com.liuleshuai.playandroid.utils;

import android.app.Activity;

import java.util.LinkedList;

/**
 * stack管理
 */
public class ActivityManager {
    private static ActivityManager activityManager;
    private LinkedList<Activity> activityList;

    public static ActivityManager getInstance() {
        if (activityManager == null) {
            synchronized (ActivityManager.class) {
                if (activityManager == null) {
                    activityManager = new ActivityManager();
                }
            }
        }
        return activityManager;
    }

    public void addActivity(Activity activity) {
        if (activityList == null) {
            activityList = new LinkedList<>();
        }
        activityList.push(activity);
    }

    public void removeActivity(Activity activity) {
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    /**
     * 获取当前的Activity
     */
    public void getCurrentActivity() {
        if (!activityList.isEmpty()) {
            activityList.peek();
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        if (activityList != null) {
            synchronized (activityList) {
                for (Activity activity : activityList) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
