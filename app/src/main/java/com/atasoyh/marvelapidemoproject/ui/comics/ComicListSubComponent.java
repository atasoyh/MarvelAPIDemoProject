package com.atasoyh.marvelapidemoproject.ui.comics;

import dagger.Subcomponent;

/**
 * Created by atasoyh on 29/06/2017.
 */
@ComicListScope
@Subcomponent(
        modules = {ComicListModule.class}
)
public interface ComicListSubComponent {

    void inject(ComicListActivity comicsActivity);
}
