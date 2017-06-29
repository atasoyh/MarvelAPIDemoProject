package com.atasoyh.appbusinesstestproject.ui.comics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsView;
import com.atasoyh.appbusinesstestproject.ui.BaseActivity;

import java.util.List;

public class ComicsActivity extends BaseActivity implements ComicsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showProgess() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showComicList(List<Comic> comicList) {

    }
}
