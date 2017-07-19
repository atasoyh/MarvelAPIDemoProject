package com.atasoyh.marvelapidemoproject.presenter.comics;

import com.atasoyh.marvelapidemoproject.model.Comic;
import com.atasoyh.marvelapidemoproject.presenter.base.BaseView;

import java.util.List;

/**
 * Created by atasoyh on 29/06/2017.
 */
public class ComicListContract {

    public interface View extends BaseView {
        void showComicList(List<Comic> comicList);
    }
}
