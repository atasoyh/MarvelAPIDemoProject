package com.atasoyh.appbusinesstestproject.presenter.comics;

import com.atasoyh.appbusinesstestproject.interactor.GetComicsInteractor;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class ComicsPresenter extends BasePresenter<ComicsContract.View> {

    GetComicsInteractor getComicsInteractor;

    @Inject
    public ComicsPresenter(ComicsContract.View view, GetComicsInteractor interactor) {
        super(view);
        getComicsInteractor =interactor;
    }

    public void loadComics() {
         view.showProgess();
         getComicsInteractor.execute(getObserver());

    }

    private void showList(List<Comic> comicList) {
        view.showComicList(comicList);
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
                view.showError(e.getLocalizedMessage());

            }

            @Override
            public void onComplete() {

            }
        };
    }

}
