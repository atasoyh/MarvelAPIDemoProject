package com.atasoyh.marvelapidemoproject.di.component;

import com.atasoyh.marvelapidemoproject.DefaultApplication;
import com.atasoyh.marvelapidemoproject.ui.base.BaseActivity;
import com.atasoyh.marvelapidemoproject.ui.comicdetail.ComicDetailModule;
import com.atasoyh.marvelapidemoproject.ui.comicdetail.ComicDetailSubComponent;
import com.atasoyh.marvelapidemoproject.ui.comics.ComicListModule;
import com.atasoyh.marvelapidemoproject.ui.comics.ComicListSubComponent;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface BaseAppComponent {

    void inject(DefaultApplication defaultApplication);
    void inject(BaseActivity activity);

    ComicListSubComponent plus(ComicListModule comicListModule);
    ComicDetailSubComponent plus(ComicDetailModule comicDetailModule);





}
