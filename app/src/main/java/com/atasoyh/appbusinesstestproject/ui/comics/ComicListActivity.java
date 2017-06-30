package com.atasoyh.appbusinesstestproject.ui.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicListContract;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsPresenter;
import com.atasoyh.appbusinesstestproject.ui.base.BaseActivity;
import com.atasoyh.appbusinesstestproject.ui.comicdetail.ComicDetailActivity;

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
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Comic item) {
        Toast.makeText(this, item.getId(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ComicDetailActivity.class);
        intent.putExtra(ComicDetailActivity.COMIC_ID, item.getId());
        startActivity(intent);
    }
}
