package com.atasoyh.marvelapidemoproject.presenter.comics.di.component;

import com.atasoyh.marvelapidemoproject.di.component.BaseAppComponent;
import com.atasoyh.marvelapidemoproject.di.modules.AppModule;
import com.atasoyh.marvelapidemoproject.presenter.comics.di.module.TestServiceModule;
import com.atasoyh.marvelapidemoproject.ui.comicdetail.ComicDetailActivityTest;
import com.atasoyh.marvelapidemoproject.ui.comics.ComicListActivityTest;

import dagger.Component;

/**
 * Created by atasoyh on 12/07/2017.
 */
@Component(modules = {AppModule.class, TestServiceModule.class})
public interface TestComponent extends BaseAppComponent {

    void inject(ComicListActivityTest comicListActivityTest);

    void inject(ComicDetailActivityTest comicDetailActivityTest);
}
