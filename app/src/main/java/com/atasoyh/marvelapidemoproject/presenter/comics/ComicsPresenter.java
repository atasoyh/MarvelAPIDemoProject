package com.atasoyh.marvelapidemoproject.presenter.comics;

import com.atasoyh.marvelapidemoproject.interactor.GetComicListInteractor;
import com.atasoyh.marvelapidemoproject.model.Comic;
import com.atasoyh.marvelapidemoproject.presenter.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class ComicsPresenter extends BasePresenter<ComicListContract.View> {

    GetComicListInteractor getComicListInteractor;

    @Inject
    public ComicsPresenter(ComicListContract.View view, GetComicListInteractor interactor) {
        super(view);
        getComicListInteractor =interactor;
    }

    public void loadComics() {
         view.showProgess();
         getComicListInteractor.getComics().subscribe(getObserver());

    }

    private Observer<List<Comic>> getObserver() {
        return new Observer<List<Comic>>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Comic> userList) {
                view.dismissProgress();
                view.showComicList(userList);


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
