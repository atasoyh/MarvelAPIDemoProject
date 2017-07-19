package com.atasoyh.marvelapidemoproject.presenter.comics;

import com.atasoyh.marvelapidemoproject.DefaultApplication;
import com.atasoyh.marvelapidemoproject.di.component.BaseAppComponent;
import com.atasoyh.marvelapidemoproject.di.modules.AppModule;
import com.atasoyh.marvelapidemoproject.presenter.comics.di.component.DaggerTestComponent;
import com.atasoyh.marvelapidemoproject.presenter.comics.di.module.TestServiceModule;

/**
 * Created by atasoyh on 12/07/2017.
 */

public class TestApplication extends DefaultApplication {

    @Override
    public BaseAppComponent createAppComponent() {
        return DaggerTestComponent.builder().appModule(new AppModule(this)).testServiceModule(new TestServiceModule()).build();
    }
}
