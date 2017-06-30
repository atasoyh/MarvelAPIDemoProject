package com.atasoyh.appbusinesstestproject.di.modules;


import android.content.Context;
import android.content.res.Configuration;

import com.atasoyh.appbusinesstestproject.BuildConfig;
import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.api.MarvelApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
