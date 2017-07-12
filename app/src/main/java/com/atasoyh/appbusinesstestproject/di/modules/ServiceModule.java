package com.atasoyh.appbusinesstestproject.di.modules;

import android.content.Context;

import com.atasoyh.appbusinesstestproject.BuildConfig;
import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.interactor.api.MarvelApi;
import com.atasoyh.appbusinesstestproject.util.DateTypeDeserializer;
import com.atasoyh.appbusinesstestproject.util.HashGenerator;
import com.atasoyh.appbusinesstestproject.util.PriceFormatterUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by atasoyh on 29/06/2017.
 */

@Module
public class ServiceModule {

    @Provides
    @Singleton
    public OkHttpClient provideLoggingCapableAndApiKeyHttpClient(@Named("publicKey") final String publicKey,@Named("privateKey") final String privateKey) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                long currentTimestamp = PriceFormatterUtil.getCurrentTimestamp();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apikey", publicKey)
                        .addQueryParameter("hash", HashGenerator.generate(currentTimestamp,privateKey,publicKey))
                        .addQueryParameter("ts",String.valueOf(currentTimestamp))
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return new OkHttpClient.Builder()
                .addInterceptor(logging).addInterceptor(interceptor)
                .build();
    }

    @Named("publicKey")
    @Provides
    public String providePublicKey(Context context) {
        return context.getString(R.string.marvel_api_public_key);
    }
    @Named("privateKey")
    @Provides
    public String providePrivateKey(Context context) {
        return context.getString(R.string.marvel_api_private_key);
    }




    @Named("url")
    @Provides
    public String provideApiUrl()
    {
        return MarvelApi.API_URL;
    }




    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient,@Named("url") String url, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public MarvelApi provideMarvelAPI(Retrofit retrofit) {
        return retrofit.create(MarvelApi.class);
    }
}
