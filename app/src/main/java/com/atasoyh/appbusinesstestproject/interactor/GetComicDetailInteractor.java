package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.interactor.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface GetComicDetailInteractor {

    void getComicDetail(Observer<Comic> observer, String id);
}

