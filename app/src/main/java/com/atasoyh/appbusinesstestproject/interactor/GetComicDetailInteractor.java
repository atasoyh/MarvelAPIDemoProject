package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.model.Comic;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface GetComicDetailInteractor {

    Observable<Comic> getComicDetail(String id);
}

