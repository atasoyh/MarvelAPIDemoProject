package com.atasoyh.marvelapidemoproject.ui.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.atasoyh.marvelapidemoproject.DefaultApplication;
import com.atasoyh.marvelapidemoproject.R;
import com.atasoyh.marvelapidemoproject.model.Comic;
import com.atasoyh.marvelapidemoproject.presenter.comics.ComicListContract;
import com.atasoyh.marvelapidemoproject.presenter.comics.ComicsPresenter;
import com.atasoyh.marvelapidemoproject.ui.base.BaseActivity;
import com.atasoyh.marvelapidemoproject.ui.comicdetail.ComicDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicListActivity extends BaseActivity implements ComicListContract.View, ComicListAdapter.OnItemClickListener {

    @Inject
    ComicsPresenter comicsPresenter;

    @BindView(R.id.rv)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_comics);
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
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
        ComicListAdapter adapter = new ComicListAdapter(comicList);
        adapter.setOnItemClickListener(this);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Comic item) {
        Intent intent = new Intent(this, ComicDetailActivity.class);
        intent.putExtra(ComicDetailActivity.COMIC_ID, item.getId());
        startActivity(intent);
    }
}
