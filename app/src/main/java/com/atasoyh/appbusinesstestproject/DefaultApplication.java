package com.atasoyh.appbusinesstestproject;

import android.app.Application;
import android.content.Context;

import com.atasoyh.appbusinesstestproject.di.component.AppComponent;
import com.atasoyh.appbusinesstestproject.di.component.DaggerAppComponent;
import com.atasoyh.appbusinesstestproject.di.modules.AppModule;
import com.atasoyh.appbusinesstestproject.presenter.comics.ComicsContract;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicsActivityModule;
import com.atasoyh.appbusinesstestproject.ui.comics.ComicsActivitySubComponent;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class DefaultApplication extends Application {


    private AppComponent appComponent;
    private ComicsActivitySubComponent comicsActivitySubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //create appComponent
        createAppComponent();
    }

    private void createAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public ComicsActivitySubComponent getComicsActivitySubComponent(ComicsContract.View view) {
        if (comicsActivitySubComponent == null) {
            comicsActivitySubComponent = appComponent.plus(new ComicsActivityModule(view));
        }
        return comicsActivitySubComponent;
    }

    public void removeComicsActivitySubComponent() {
        comicsActivitySubComponent = null;
    }


    public static DefaultApplication get(Context context) {
        return (DefaultApplication) context.getApplicationContext();
    }
}
