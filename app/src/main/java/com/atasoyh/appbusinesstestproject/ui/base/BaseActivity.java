package com.atasoyh.appbusinesstestproject.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.presenter.base.BaseView;

/**
 * Created by atasoyh on 29/06/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(DefaultApplication.get(this));
    }

    protected abstract void injectDependencies(DefaultApplication application);

    @Override
    public void finish() {
        super.finish();
        releaseSubComponents(DefaultApplication.get(this));
    }

    protected abstract void releaseSubComponents(DefaultApplication application);

    @Override
    public void showProgess() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
