package com.atasoyh.appbusinesstestproject.di.modules;


import android.content.Context;
import android.content.res.Configuration;

import com.atasoyh.appbusinesstestproject.DefaultApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by atasoyh on 29/06/2017.
 */

@Module
public class AppModule {

    private final DefaultApplication mApplication;

    public AppModule(DefaultApplication app) {
        mApplication = app;
    }

    @Provides
    public Context getContext(){
        return mApplication;
    }

    @Provides
    public Configuration getConfiguration(Context context){
        return context.getResources().getConfiguration();
    }


}
