package com.atasoyh.marvelapidemoproject.presenter.comicdetail;

import com.atasoyh.marvelapidemoproject.interactor.GetComicDetailInteractor;
import com.atasoyh.marvelapidemoproject.model.Comic;
import com.atasoyh.marvelapidemoproject.model.ComicResponse;
import com.atasoyh.marvelapidemoproject.util.DateTypeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by atasoyh on 12/07/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ComicDetailPresenterTest {

    private String mockResponse = "{\"code\":200,\"status\":\"Ok\",\"copyright\":\"© 2017 MARVEL\",\"attributionText\":\"Data provided by Marvel. © 2017 MARVEL\",\"attributionHTML\":\"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2017 MARVEL</a>\",\"etag\":\"04fd424c1220776a5a3c5413a8222fcc15ab86ed\",\"data\":{\"offset\":0,\"limit\":20,\"total\":1,\"count\":1,\"results\":[{\"id\":384,\"digitalId\":0,\"title\":\"Gun Theory (2003) #3\",\"issueNumber\":3,\"variantDescription\":\"\",\"description\":\"The phone rings, and killer-for-hire Harvey embarks on another hit. But nothing's going right this job. There's little room for error in the business of killing - so what happens when one occurs?\\r\\n\\r\\n32 PGS./ PARENTAL ADVISORY ...$2.50\",\"modified\":\"-0001-11-30T00:00:00-0500\",\"isbn\":\"\",\"upc\":\"5960605492-00411\",\"diamondCode\":\"\",\"ean\":\"\",\"issn\":\"\",\"format\":\"Comic\",\"pageCount\":0,\"textObjects\":[{\"type\":\"issue_solicit_text\",\"language\":\"en-us\",\"text\":\"The phone rings, and killer-for-hire Harvey embarks on another hit. But nothing's going right this job. There's little room for error in the business of killing - so what happens when one occurs?\\r\\n\\r\\n32 PGS./ PARENTAL ADVISORY ...$2.50\"}],\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/384\",\"urls\":[{\"type\":\"detail\",\"url\":\"http://marvel.com/comics/issue/384/gun_theory_2003_3?utm_campaign=apiRef&utm_source=18d148ca86bd623d2b2b9acdc736e034\"}],\"series\":{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/649\",\"name\":\"Gun Theory (2003)\"},\"variants\":[],\"collections\":[],\"collectedIssues\":[],\"dates\":[{\"type\":\"onsaleDate\",\"date\":\"2029-12-31T00:00:00-0500\"},{\"type\":\"focDate\",\"date\":\"-0001-11-30T00:00:00-0500\"}],\"prices\":[{\"type\":\"printPrice\",\"price\":2.5}],\"thumbnail\":{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75\",\"extension\":\"jpg\"},\"images\":[{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75\",\"extension\":\"jpg\"}],\"creators\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/creators\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/576\",\"name\":\"Jon Proctor\",\"role\":\"penciller (cover)\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/344\",\"name\":\"Daniel Way\",\"role\":\"writer\"}],\"returned\":2},\"characters\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/characters\",\"items\":[],\"returned\":0},\"stories\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/stories\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/2538\",\"name\":\"Cover #2538\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/2539\",\"name\":\"Interior #2539\",\"type\":\"interiorStory\"}],\"returned\":2},\"events\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/events\",\"items\":[],\"returned\":0}}]}}\n";

    private String mockId = "1";

    @Mock
    ComicDetailContract.View view;

    @Mock
    GetComicDetailInteractor interactor;

    ComicDetailPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ComicDetailPresenter(view, interactor, mockId);
    }

    @Test
    public void isComicIdNullTest() throws Exception{
        presenter.comicId=null;
        presenter.loadComicDetail();
        verifyNoMoreInteractions(interactor);
        verify(view,times(1)).showComicIdErrorAndFinishActivity();
    }

    @Test
    public void isComicIdEmptyTest() throws Exception{
        presenter.comicId="";
        presenter.loadComicDetail();
        verifyNoMoreInteractions(interactor);
        verify(view,times(1)).showComicIdErrorAndFinishActivity();
    }

    @Test
    public void loadComicDetail() throws Exception {
        when(interactor.getComicDetail(eq(mockId))).thenReturn(new Observable<Comic>() {
            @Override
            protected void subscribeActual(Observer<? super Comic> observer) {
                Gson gson=new GsonBuilder()
                        .registerTypeAdapter(Date.class, new DateTypeDeserializer())
                        .create();
                ComicResponse comicResponse = gson.fromJson(mockResponse, ComicResponse.class);
                observer.onNext(comicResponse.getData().getComics().get(0));
                observer.onComplete();
            }
        });


        presenter.loadComicDetail();

        verify(interactor,times(1)).getComicDetail(mockId);
        verify(view,times(1)).showProgess();
        verify(view,times(1)).showPage(anyString());
        verify(view,times(1)).showTitle(anyString());
        verify(view,times(1)).showDescription(anyString());
        verify(view,times(1)).showImage(anyString());
        verify(view,times(1)).showPrice(any(List.class));
        verify(view,times(1)).dismissProgress();
        verify(view,never()).showComicIdErrorAndFinishActivity();
    }


    @After
    public void tearDown() throws Exception {
    }


}