package com.atasoyh.appbusinesstestproject.presenter.comicdetail;

import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.model.ComicPrice;
import com.atasoyh.appbusinesstestproject.presenter.base.BaseView;

import java.util.List;

/**
 * Created by atasoyh on 29/06/2017.
 */
public class ComicDetailContract {

    public interface View extends BaseView {

        void showTitle(String title);
        void showImage(String url);
        void showDescription(String description);
        void showPage(String page);
        void showPrice(List<ComicPrice> prices);
        void showAuthor(String author);

        void showComicIdErrorAndFinishActivity();

    }
}
