package com.atasoyh.marvelapidemoproject.interactor;

import com.atasoyh.marvelapidemoproject.interactor.api.MarvelApi;
import com.atasoyh.marvelapidemoproject.model.Comic;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by atasoyh on 12/07/2017.
 */

public class GetComicDetailInteractorImpl implements GetComicDetailInteractor {

    MarvelApi marvelApi;

    @Inject
    public GetComicDetailInteractorImpl(MarvelApi marvelApi) {
        this.marvelApi = marvelApi;
    }


    public Observable<Comic> getComicDetail(String id) {
        return this.marvelApi.getComicById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(comicResponse -> comicResponse.getData().getComics().get(0));
    }
}
