package com.atasoyh.marvelapidemoproject.presenter.comicdetail;

import com.atasoyh.marvelapidemoproject.model.ComicPrice;
import com.atasoyh.marvelapidemoproject.presenter.base.BaseView;

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
