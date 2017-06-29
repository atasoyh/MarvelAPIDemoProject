package com.atasoyh.appbusinesstestproject.presenter;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class BasePresenter<T extends BaseView> {
    protected T view;
    public BasePresenter(T view) {
        this.view=view;
    }
}
