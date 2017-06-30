package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class GetComicDetailInteractor {


    MarvelApi marvelApi;

    @Inject
    public GetComicDetailInteractor(MarvelApi marvelApi) {
        this.marvelApi = marvelApi;
    }

    public void execute(Observer<Comic> observer,String id) {
        this.marvelApi.getComicById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(new Function<ComicResponse, Comic>() {
                    @Override
                    public Comic apply(ComicResponse comicResponse) throws Exception {
                        return comicResponse.getData().getComics().get(0);

                    }
                }).subscribe(observer);
        ;

    }
}

