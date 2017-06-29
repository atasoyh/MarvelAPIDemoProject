package com.atasoyh.appbusinesstestproject.presenter.base;

import com.atasoyh.appbusinesstestproject.model.Comic;

import java.util.List;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface BaseView {
    void showProgess();
    void dismissProgress();
    void showError(String message);
}
