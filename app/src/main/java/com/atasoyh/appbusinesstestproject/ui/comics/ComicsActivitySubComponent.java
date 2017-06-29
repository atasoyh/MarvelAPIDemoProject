package com.atasoyh.appbusinesstestproject.ui.comics;

import dagger.Subcomponent;

/**
 * Created by atasoyh on 29/06/2017.
 */
@ComicsScope
@Subcomponent(
        modules = {ComicsActivityModule.class}
)
public interface ComicsActivitySubComponent {

    void inject(ComicsActivity comicsActivity);
}
