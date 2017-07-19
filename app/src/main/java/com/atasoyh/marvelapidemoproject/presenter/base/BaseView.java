package com.atasoyh.marvelapidemoproject.presenter.base;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface BaseView {
    void showProgess();
    void dismissProgress();
    void showError(String message);
}
