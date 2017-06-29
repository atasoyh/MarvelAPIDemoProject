package com.atasoyh.appbusinesstestproject.presenter.base;

/**
 * Created by atasoyh on 29/06/2017.
 */

public abstract class BasePresenter<T extends BaseView> {

    protected T view;

    public BasePresenter(T view) {
        this.view=view;
    }

    public void handleErrors(Throwable t){
        view.showError(t.getMessage());
    }
}
