package com.atasoyh.appbusinesstestproject.presenter.comics;

import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.BasePresenter;
import com.atasoyh.appbusinesstestproject.presenter.BaseView;

import java.util.List;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class ComicsPresenter extends BasePresenter{

    public ComicsPresenter(ComicsView view) {
        super(view);
    }

    public void loadComics(){
        view.showProgess();
        //todo request or load data...
        view.dismissProgress();
    }

    private void showList(List<Comic> comicList){
        ((ComicsView)view).showComicList(comicList);
    }



}
