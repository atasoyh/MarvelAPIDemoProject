package com.atasoyh.marvelapidemoproject.presenter.comicdetail;

import com.atasoyh.marvelapidemoproject.interactor.GetComicDetailInteractor;
import com.atasoyh.marvelapidemoproject.model.Comic;
import com.atasoyh.marvelapidemoproject.presenter.base.BasePresenter;
import com.atasoyh.marvelapidemoproject.util.TextUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class ComicDetailPresenter extends BasePresenter<ComicDetailContract.View> {

    GetComicDetailInteractor comicDetailInteractor;
    String comicId;

    @Inject
    public ComicDetailPresenter(ComicDetailContract.View view, GetComicDetailInteractor interactor, String comicId) {
        super(view);
        this.comicDetailInteractor = interactor;
        this.comicId = comicId;

    }

    private boolean checkID() {
        return !TextUtils.isEmpty(comicId);
    }

    public void loadComicDetail() {
        if (checkID()) {
            view.showProgess();
            comicDetailInteractor.getComicDetail(comicId).subscribe(getObserver());
        } else {
            view.showComicIdErrorAndFinishActivity();
        }
    }


    private Observer<Comic> getObserver() {
        return new Observer<Comic>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Comic comic) {
                view.dismissProgress();
                view.showAuthor(comic.getCreators().getCreatorSummaries().get(0).getName());
                view.showImage(comic.getThumbnail().getUrl());
                view.showDescription(comic.getDescription());
                view.showPrice(comic.getPrices());
                view.showTitle(comic.getTitle());
                view.showPage(comic.getPageCount());

            }

            @Override
            public void onError(Throwable e) {
                view.dismissProgress();
                view.showError(e.getLocalizedMessage());

            }

            @Override
            public void onComplete() {

            }
        };
    }


}
