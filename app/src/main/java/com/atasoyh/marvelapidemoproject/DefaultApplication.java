package com.atasoyh.marvelapidemoproject;

import android.app.Application;
import android.content.Context;

import com.atasoyh.marvelapidemoproject.di.component.BaseAppComponent;
import com.atasoyh.marvelapidemoproject.di.component.DaggerAppComponent;
import com.atasoyh.marvelapidemoproject.di.modules.AppModule;
import com.atasoyh.marvelapidemoproject.di.modules.ServiceModule;
import com.atasoyh.marvelapidemoproject.presenter.comicdetail.ComicDetailContract;
import com.atasoyh.marvelapidemoproject.presenter.comics.ComicListContract;
import com.atasoyh.marvelapidemoproject.ui.comicdetail.ComicDetailModule;
import com.atasoyh.marvelapidemoproject.ui.comicdetail.ComicDetailSubComponent;
import com.atasoyh.marvelapidemoproject.ui.comics.ComicListModule;
import com.atasoyh.marvelapidemoproject.ui.comics.ComicListSubComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class DefaultApplication extends Application {


    public BaseAppComponent appComponent;
    private ComicListSubComponent comicListSubComponent;
    private ComicDetailSubComponent comicDetailSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //facebook's imageloader library
        Fresco.initialize(this);
        //create appComponent
        appComponent = createAppComponent();
        appComponent.inject(this);
    }

    public BaseAppComponent createAppComponent() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).serviceModule(new ServiceModule()).build();
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
