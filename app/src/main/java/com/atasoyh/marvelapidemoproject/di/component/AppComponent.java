package com.atasoyh.marvelapidemoproject.di.component;

import com.atasoyh.marvelapidemoproject.di.modules.AppModule;
import com.atasoyh.marvelapidemoproject.di.modules.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by atasoyh on 29/06/2017.
 */

@Singleton
@Component(modules = {AppModule.class, ServiceModule.class})
public interface AppComponent extends BaseAppComponent{
}
