package com.liuleshuai.playandroid.base;

public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements BaseView {
    protected T mPresenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 注入依赖
     */
    protected abstract void initInject();
}
