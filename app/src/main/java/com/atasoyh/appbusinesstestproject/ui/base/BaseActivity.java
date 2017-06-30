package com.atasoyh.appbusinesstestproject.ui.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.presenter.base.BaseView;

import butterknife.BindView;

/**
 * Created by atasoyh on 29/06/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

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
        if(progressBar!=null) progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void dismissProgress() {
        if(progressBar!=null) progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getCurrentFocus(),message,Snackbar.LENGTH_SHORT).show();
    }
}
