package com.atasoyh.marvelapidemoproject.ui.comicdetail;

import com.atasoyh.marvelapidemoproject.interactor.GetComicDetailInteractor;
import com.atasoyh.marvelapidemoproject.interactor.GetComicDetailInteractorImpl;
import com.atasoyh.marvelapidemoproject.interactor.api.MarvelApi;
import com.atasoyh.marvelapidemoproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.marvelapidemoproject.presenter.comicdetail.ComicDetailPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by atasoyh on 29/06/2017.
 */
@Module
public class ComicDetailModule {

    ComicDetailContract.View view;
    String comicId;

    @Inject
    public ComicDetailModule(ComicDetailContract.View view,String comicId) {
        this.view = view;
        this.comicId=comicId;
    }

    @Provides
    ComicDetailContract.View getView() {
        return view;
    }

    @Provides
    GetComicDetailInteractor provideMainInteractor(MarvelApi marvelApi) {
        return new GetComicDetailInteractorImpl(marvelApi);
    }

    @Provides
    ComicDetailPresenter provideMainPresenter(ComicDetailContract.View view, GetComicDetailInteractor interactor) {
        return new ComicDetailPresenter(view, interactor,comicId);
    }
}
