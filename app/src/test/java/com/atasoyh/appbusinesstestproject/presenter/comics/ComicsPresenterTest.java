package com.atasoyh.appbusinesstestproject.presenter.comics;

import com.atasoyh.appbusinesstestproject.interactor.GetComicListInteractor;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by atasoyh on 12/07/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ComicsPresenterTest {

    @Mock
    ComicListContract.View view;

    @Mock
    GetComicListInteractor interactor;

    ComicsPresenter presenter;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter=new ComicsPresenter(view,interactor);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadComics() throws Exception {


        final List<Comic> comics=new ArrayList<>();
        for(int i=0;i<100;i++){
            comics.add(new Comic());
        }
        when(interactor.getComics()).thenReturn(new Observable<List<Comic>>() {
            @Override
            protected void subscribeActual(Observer<? super List<Comic>> observer) {
                observer.onNext(comics);
                observer.onComplete();
            }
        });


        presenter.loadComics();

        verify(view,times(1)).showProgess();
        verify(view).showComicList(ArgumentMatchers.<Comic>anyList());
        verify(view,never()).showError(anyString());
        verify(view,times(1)).dismissProgress();

    }

    @Test
    public void onErrorloadComics() throws Exception {

        when(interactor.getComics()).thenReturn(new Observable<List<Comic>>() {
            @Override
            protected void subscribeActual(Observer<? super List<Comic>> observer) {
                observer.onError(new Throwable("Test Error"));
                observer.onComplete();
            }
        });


        presenter.loadComics();

        verify(view,times(1)).showProgess();
        verify(view,never()).showComicList(ArgumentMatchers.<Comic>anyList());
        verify(view,times(1)).showError(anyString());
        verify(view,times(1)).dismissProgress();

    }

}