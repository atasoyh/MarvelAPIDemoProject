package com.atasoyh.appbusinesstestproject.presenter.comics;

import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.base.BasePresenter;
import com.atasoyh.appbusinesstestproject.presenter.base.BaseView;

import java.util.List;

/**
 * Created by atasoyh on 29/06/2017.
 */
public class ComicListContract {

    public interface View extends BaseView {
        void showComicList(List<Comic> comicList);
    }
}
