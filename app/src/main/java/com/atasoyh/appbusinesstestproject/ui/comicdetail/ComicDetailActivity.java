package com.atasoyh.appbusinesstestproject.ui.comicdetail;

import android.os.Bundle;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailPresenter;
import com.atasoyh.appbusinesstestproject.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ComicDetailActivity extends BaseActivity implements ComicDetailContract.View {

    public static final String COMIC_ID = "ComicId";
    @Inject
    ComicDetailPresenter comicDetailPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_comics);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        comicDetailPresenter.loadComicDetail();
    }

    @Override
    protected void injectDependencies(DefaultApplication application) {
        String comicId = getIntent().getStringExtra(COMIC_ID);
        application.getComicDetailSubComponent((this), comicId).inject(this);
    }

    @Override
    protected void releaseSubComponents(DefaultApplication application) {
        application.removeComicsActivitySubComponent();
    }

    @Override
    public void showComicDetail(Comic comic) {

    }

    @Override
    public void showComicIdErrorAndFinishActivity() {
        finish();
    }
}
