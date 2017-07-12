package com.atasoyh.appbusinesstestproject.di.component;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.di.modules.AppModule;
import com.atasoyh.appbusinesstestproject.di.modules.ServiceModule;
import com.atasoyh.appbusinesstestproject.ui.base.BaseActivity;
import com.atasoyh.appbusinesstestproject.ui.comicdetail.ComicDetailModule;
import com.atasoyh.appbusinesstestproject.ui.comicdetail.ComicDetailSubComponent;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicListModule;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicListSubComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by atasoyh on 29/06/2017.
 */

@Singleton
@Component(modules = {AppModule.class, ServiceModule.class})
public interface AppComponent extends BaseAppComponent{
}
