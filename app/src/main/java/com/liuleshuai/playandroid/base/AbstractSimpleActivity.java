package com.liuleshuai.playandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liuleshuai.playandroid.utils.ActivityManager;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * 基础的布置，初始化等等。
 * Created by LiuKuo at 2018/7/17
 */

public abstract class AbstractSimpleActivity extends SupportActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        onViewCreated();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
    }

    protected void onViewCreated() {

    }

    /**
     * 数据、事件初始化
     */
    protected abstract void initEventAndData();
}
