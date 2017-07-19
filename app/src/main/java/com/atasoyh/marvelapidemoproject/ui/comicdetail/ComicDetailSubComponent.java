package com.atasoyh.marvelapidemoproject.ui.comicdetail;

import dagger.Subcomponent;

/**
 * Created by atasoyh on 29/06/2017.
 */
@ComicDetailScope
@Subcomponent(
        modules = {ComicDetailModule.class}
)
public interface ComicDetailSubComponent {

    void inject(ComicDetailActivity comicsActivity);
}
