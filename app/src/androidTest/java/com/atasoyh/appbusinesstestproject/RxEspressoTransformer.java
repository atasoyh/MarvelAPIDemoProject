package com.atasoyh.appbusinesstestproject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class RxEspressoTransformer {

    private final ObservableTransformer transformer;

    public RxEspressoTransformer() {
        transformer = observable -> ((Observable) observable)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((a) -> RxEspresso.increment())
                .doAfterTerminate(RxEspresso::decrement);
    }

    public <T> ObservableTransformer<T, T> apply() {
        return (ObservableTransformer<T, T>) transformer;
    }
}	