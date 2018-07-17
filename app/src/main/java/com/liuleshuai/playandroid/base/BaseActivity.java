package com.liuleshuai.playandroid.base;

/**
 * presenter初始化（生命周期绑定？数据库初始化？）
 * 总之就是布置后的一些初始化操作！！！
 *
 * @author liukuo
 */
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
