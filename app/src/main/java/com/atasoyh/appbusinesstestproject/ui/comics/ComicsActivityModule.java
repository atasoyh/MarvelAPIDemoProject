package com.atasoyh.appbusinesstestproject.ui.comics;

import com.atasoyh.appbusinesstestproject.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.interactor.GetComicsInteractor;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsContract;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by atasoyh on 29/06/2017.
 */
@Module
public class ComicsActivityModule {

    ComicsContract.View view;

    @Inject
    public ComicsActivityModule(ComicsContract.View view) {
        this.view = view;
    }

    @Provides
    ComicsContract.View getView() {
        return view;
    }

    @Provides
    GetComicsInteractor provideMainInteractor(MarvelApi marvelApi) {
        return new GetComicsInteractor(marvelApi);
    }

    @Provides
    ComicsPresenter provideMainPresenter(ComicsContract.View view, GetComicsInteractor interactor) {
        return new ComicsPresenter(view, interactor);
    }
}
