package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class GetComicsInteractor {


    MarvelApi marvelApi;

    @Inject
    public GetComicsInteractor(MarvelApi marvelApi) {
        this.marvelApi = marvelApi;
    }

    public void execute(Observer<List<Comic>> observer) {
        this.marvelApi.getComics(0,100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(new Function<ComicResponse, List<Comic>>() {
                    @Override
                    public List<Comic> apply(ComicResponse comicResponse) throws Exception {
                        return comicResponse.getData().getComics();

                    }
                }).subscribe(observer);
        ;

    }
}

