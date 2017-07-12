package com.atasoyh.appbusinesstestproject.ui.comicdetail;

import com.atasoyh.appbusinesstestproject.interactor.GetComicDetailInteractor;
import com.atasoyh.appbusinesstestproject.interactor.GetComicDetailInteractorImpl;
import com.atasoyh.appbusinesstestproject.interactor.GetComicListInteractor;
import com.atasoyh.appbusinesstestproject.interactor.GetComicListInteractorImpl;
import com.atasoyh.appbusinesstestproject.interactor.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailPresenter;

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
