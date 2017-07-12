package com.atasoyh.appbusinesstestproject.interactor;

import com.atasoyh.appbusinesstestproject.model.Comic;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface GetComicListInteractor {
    Observable<List<Comic>> getComics();
}

