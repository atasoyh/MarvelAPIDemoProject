package com.atasoyh.appbusinesstestproject.presenter.comics.di.component;

import com.atasoyh.appbusinesstestproject.di.component.BaseAppComponent;
import com.atasoyh.appbusinesstestproject.di.modules.AppModule;
import com.atasoyh.appbusinesstestproject.presenter.comics.di.module.TestServiceModule;
import com.atasoyh.appbusinesstestproject.ui.base.BaseActivity;
import com.atasoyh.appbusinesstestproject.ui.comicdetail.ComicDetailActivityTest;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicListActivityTest;

import dagger.Component;

/**
 * Created by atasoyh on 12/07/2017.
 */
@Component(modules = {AppModule.class, TestServiceModule.class})
public interface TestComponent extends BaseAppComponent {

    void inject(ComicListActivityTest comicListActivityTest);

    void inject(ComicDetailActivityTest comicDetailActivityTest);
}
