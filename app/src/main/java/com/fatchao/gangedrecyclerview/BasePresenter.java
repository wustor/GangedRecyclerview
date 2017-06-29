package com.fatchao.gangedrecyclerview;

public abstract class BasePresenter {

    protected ViewCallBack mViewCallBack;

    void add(ViewCallBack viewCallBack) {
        this.mViewCallBack = viewCallBack;
    }

    void remove() {
        this.mViewCallBack = null;
    }

    protected abstract void getData();
}
