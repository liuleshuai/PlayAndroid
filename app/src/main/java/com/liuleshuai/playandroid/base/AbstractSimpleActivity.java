package com.liuleshuai.playandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by LiuKuo at 2018/7/17
 */

public abstract class AbstractSimpleActivity extends SupportActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onViewCreated();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onViewCreated() {

    }

    /**
     * 数据、事件初始化
     */
    protected abstract void initEventAndData();
}
