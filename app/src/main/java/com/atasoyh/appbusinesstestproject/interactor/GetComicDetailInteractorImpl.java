package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.interactor.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
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
                .map(new Function<ComicResponse, Comic>() {
                    @Override
                    public Comic apply(ComicResponse comicResponse) throws Exception {
                        return comicResponse.getData().getComics().get(0);

                    }
                });
    }
}
