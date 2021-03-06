package com.atasoyh.marvelapidemoproject.ui.comics;

import com.atasoyh.marvelapidemoproject.interactor.GetComicListInteractor;
import com.atasoyh.marvelapidemoproject.interactor.GetComicListInteractorImpl;
import com.atasoyh.marvelapidemoproject.interactor.api.MarvelApi;
import com.atasoyh.marvelapidemoproject.presenter.comics.ComicListContract;
import com.atasoyh.marvelapidemoproject.presenter.comics.ComicsPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by atasoyh on 29/06/2017.
 */
@Module
public class ComicListModule {

    ComicListContract.View view;

    @Inject
    public ComicListModule(ComicListContract.View view) {
        this.view = view;
    }

    @Provides
    ComicListContract.View getView() {
        return view;
    }

    @Provides
    GetComicListInteractor provideMainInteractor(MarvelApi marvelApi) {
        return new GetComicListInteractorImpl(marvelApi);
    }

    @Provides
    ComicsPresenter provideMainPresenter(ComicListContract.View view, GetComicListInteractor interactor) {
        return new ComicsPresenter(view, interactor);
    }
}
