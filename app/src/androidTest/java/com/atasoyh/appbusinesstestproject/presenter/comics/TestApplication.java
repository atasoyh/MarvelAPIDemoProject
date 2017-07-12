package com.atasoyh.appbusinesstestproject.presenter.comics;

import com.atasoyh.appbusinesstestproject.DefaultApplication;
import com.atasoyh.appbusinesstestproject.di.component.BaseAppComponent;
import com.atasoyh.appbusinesstestproject.di.modules.AppModule;
import com.atasoyh.appbusinesstestproject.presenter.comics.di.component.DaggerTestComponent;
import com.atasoyh.appbusinesstestproject.presenter.comics.di.module.TestServiceModule;

/**
 * Created by atasoyh on 12/07/2017.
 */

public class TestApplication extends DefaultApplication {

    @Override
    public BaseAppComponent createAppComponent() {
        return DaggerTestComponent.builder().appModule(new AppModule(this)).testServiceModule(new TestServiceModule()).build();
    }
}
