package com.liuleshuai.playandroid.base;

public interface AbstractPresenter<T extends BaseView>{
    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();
}
