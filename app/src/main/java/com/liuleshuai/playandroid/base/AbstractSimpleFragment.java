package com.liuleshuai.playandroid.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liuleshuai.playandroid.utils.ToastUtil;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by LiuKuo at 2018/7/17
 */

public abstract class AbstractSimpleFragment extends SupportFragment {
    private long clickTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEventAndData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        lazyInit();
    }


    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            long currentTime = System.currentTimeMillis();
            long interval = 2000;
            if (currentTime - clickTime > interval) {
                ToastUtil.show(_mActivity, "Press the back button again to exit", Gravity.CENTER, Toast.LENGTH_LONG);
                clickTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
            }
        }
        return true;
    }

    /**
     * 布局加载
     */
    @IdRes
    protected abstract int getLayoutId();

    /**
     * 懒加载初始化
     */
    protected abstract void lazyInit();

    /**
     * 数据、事件初始化
     */
    protected abstract void initEventAndData();
}
