package com.atasoyh.appbusinesstestproject.ui.comicdetail;

import com.atasoyh.appbusinesstestproject.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.interactor.GetComicDetailInteractor;
import com.atasoyh.appbusinesstestproject.interactor.GetComicListInteractor;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailPresenter;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicListContract;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsPresenter;

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
    GetComicListInteractor provideMainInteractor(MarvelApi marvelApi) {
        return new GetComicListInteractor(marvelApi);
    }

    @Provides
    ComicDetailPresenter provideMainPresenter(ComicDetailContract.View view, GetComicDetailInteractor interactor) {
        return new ComicDetailPresenter(view, interactor,comicId);
    }
}
