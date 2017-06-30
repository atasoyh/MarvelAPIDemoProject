package com.atasoyh.appbusinesstestproject;

import android.app.Application;
import android.content.Context;

import com.atasoyh.appbusinesstestproject.di.component.AppComponent;
import com.atasoyh.appbusinesstestproject.di.component.DaggerAppComponent;
import com.atasoyh.appbusinesstestproject.di.modules.AppModule;
import com.atasoyh.appbusinesstestproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicListContract;
import com.atasoyh.appbusinesstestproject.ui.comicdetail.ComicDetailModule;
import com.atasoyh.appbusinesstestproject.ui.comicdetail.ComicDetailSubComponent;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicListModule;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicListSubComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class DefaultApplication extends Application {


    private AppComponent appComponent;
    private ComicListSubComponent comicListSubComponent;
    private ComicDetailSubComponent comicDetailSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //facebook's imageloader library
        Fresco.initialize(this);
        //create appComponent
        createAppComponent();
    }

    private void createAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public ComicListSubComponent getComicsActivitySubComponent(ComicListContract.View view) {
        if (comicListSubComponent == null) {
            comicListSubComponent = appComponent.plus(new ComicListModule(view));
        }
        return comicListSubComponent;
    }

    public void removeComicsActivitySubComponent() {
        comicListSubComponent = null;
    }

    public ComicDetailSubComponent getComicDetailSubComponent(ComicDetailContract.View view, String comicId) {
        if (comicDetailSubComponent == null) {
            comicDetailSubComponent = appComponent.plus(new ComicDetailModule(view, comicId));
        }
        return comicDetailSubComponent;
    }

    public void removeComicDetailSubComponent() {
        comicDetailSubComponent = null;
    }


    public static DefaultApplication get(Context context) {
        return (DefaultApplication) context.getApplicationContext();
    }
}
