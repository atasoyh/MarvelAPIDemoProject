package com.atasoyh.appbusinesstestproject.ui.comics;

import android.os.Bundle;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsContract;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsPresenter;
import com.atasoyh.appbusinesstestproject.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class ComicsActivity extends BaseActivity implements ComicsContract.View {

    @Inject
    ComicsPresenter comicsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        comicsPresenter.loadComics();
    }

    @Override
    protected void injectDependencies(DefaultApplication application) {
        application.getComicsActivitySubComponent((this)).inject(this);
    }

    @Override
    protected void releaseSubComponents(DefaultApplication application) {
        application.removeComicsActivitySubComponent();
    }


    @Override
    public void showComicList(List<Comic> comicList) {

    }
}
