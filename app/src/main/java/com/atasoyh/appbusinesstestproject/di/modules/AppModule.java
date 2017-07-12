package com.atasoyh.appbusinesstestproject.di.modules;


import android.content.Context;
import android.content.res.Configuration;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.util.DateTypeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

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

    @Provides
    public Gson provideGson()
    {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTypeDeserializer())
                .create();
    }


}
