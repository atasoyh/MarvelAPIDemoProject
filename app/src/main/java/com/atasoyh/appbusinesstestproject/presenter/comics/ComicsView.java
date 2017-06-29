package com.atasoyh.appbusinesstestproject.presenter.comics;

import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.BaseView;

import java.util.List;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface ComicsView extends BaseView {

    void showComicList(List<Comic> comicList);
}
