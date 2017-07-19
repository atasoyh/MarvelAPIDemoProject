package com.atasoyh.marvelapidemoproject.interactor;

import com.atasoyh.marvelapidemoproject.model.Comic;

import io.reactivex.Observable;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface GetComicDetailInteractor {

    Observable<Comic> getComicDetail(String id);
}

