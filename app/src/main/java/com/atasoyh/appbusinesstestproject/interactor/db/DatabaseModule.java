package com.atasoyh.appbusinesstestproject.interactor.db;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DatabaseModule {

    @Provides
    @Singleton
    DatabaseHelper provideDatabaseHelperService(DatabaseHelperImpl databaseHelper) {
        return databaseHelper;
    }

}
