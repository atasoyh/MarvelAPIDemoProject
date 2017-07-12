package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.interactor.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
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
                .map(new Function<ComicResponse, List<Comic>>() {
                    @Override
                    public List<Comic> apply(ComicResponse comicResponse) throws Exception {
                        return comicResponse.getData().getComics();

                    }
                });
    }
}
