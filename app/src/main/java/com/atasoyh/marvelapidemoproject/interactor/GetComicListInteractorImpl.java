package com.atasoyh.marvelapidemoproject.interactor;

import com.atasoyh.marvelapidemoproject.interactor.api.MarvelApi;
import com.atasoyh.marvelapidemoproject.model.Comic;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by atasoyh on 12/07/2017.
 */

public class GetComicListInteractorImpl implements GetComicListInteractor {

    MarvelApi marvelApi;

    @Inject
    public GetComicListInteractorImpl(MarvelApi marvelApi) {
        this.marvelApi = marvelApi;
    }


    @Override
    public Observable<List<Comic>> getComics() {
        return this.marvelApi.getComics(0,100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(comicResponse->comicResponse.getData().getComics());
    }
}
