package com.atasoyh.marvelapidemoproject.ui.comicdetail;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.atasoyh.marvelapidemoproject.DefaultApplication;
import com.atasoyh.marvelapidemoproject.R;
import com.atasoyh.marvelapidemoproject.RxEspresso;
import com.atasoyh.marvelapidemoproject.RxEspressoTransformer;
import com.atasoyh.marvelapidemoproject.interactor.api.MarvelApi;
import com.atasoyh.marvelapidemoproject.model.ComicResponse;
import com.atasoyh.marvelapidemoproject.presenter.comics.di.component.TestComponent;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by atasoyh on 12/07/2017.
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class ComicDetailActivityTest {

    String mockComicResponse = "{\"code\":200,\"status\":\"Ok\",\"copyright\":\"© 2017 MARVEL\",\"attributionText\":\"Data provided by Marvel. © 2017 MARVEL\",\"attributionHTML\":\"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2017 MARVEL</a>\",\"etag\":\"04fd424c1220776a5a3c5413a8222fcc15ab86ed\",\"data\":{\"offset\":0,\"limit\":20,\"total\":1,\"count\":1,\"results\":[{\"id\":384,\"digitalId\":0,\"title\":\"Gun Theory (2003) #3\",\"issueNumber\":3,\"variantDescription\":\"\",\"description\":\"The phone rings, and killer-for-hire Harvey embarks on another hit. But nothing's going right this job. There's little room for error in the business of killing - so what happens when one occurs?\\r\\n\\r\\n32 PGS./ PARENTAL ADVISORY ...$2.50\",\"modified\":\"-0001-11-30T00:00:00-0500\",\"isbn\":\"\",\"upc\":\"5960605492-00411\",\"diamondCode\":\"\",\"ean\":\"\",\"issn\":\"\",\"format\":\"Comic\",\"pageCount\":0,\"textObjects\":[{\"type\":\"issue_solicit_text\",\"language\":\"en-us\",\"text\":\"The phone rings, and killer-for-hire Harvey embarks on another hit. But nothing's going right this job. There's little room for error in the business of killing - so what happens when one occurs?\\r\\n\\r\\n32 PGS./ PARENTAL ADVISORY ...$2.50\"}],\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/384\",\"urls\":[{\"type\":\"detail\",\"url\":\"http://marvel.com/comics/issue/384/gun_theory_2003_3?utm_campaign=apiRef&utm_source=18d148ca86bd623d2b2b9acdc736e034\"}],\"series\":{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/649\",\"name\":\"Gun Theory (2003)\"},\"variants\":[],\"collections\":[],\"collectedIssues\":[],\"dates\":[{\"type\":\"onsaleDate\",\"date\":\"2029-12-31T00:00:00-0500\"},{\"type\":\"focDate\",\"date\":\"-0001-11-30T00:00:00-0500\"}],\"prices\":[{\"type\":\"printPrice\",\"price\":2.5}],\"thumbnail\":{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75\",\"extension\":\"jpg\"},\"images\":[{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75\",\"extension\":\"jpg\"}],\"creators\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/creators\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/576\",\"name\":\"Jon Proctor\",\"role\":\"penciller (cover)\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/344\",\"name\":\"Daniel Way\",\"role\":\"writer\"}],\"returned\":2},\"characters\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/characters\",\"items\":[],\"returned\":0},\"stories\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/stories\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/2538\",\"name\":\"Cover #2538\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/2539\",\"name\":\"Interior #2539\",\"type\":\"interiorStory\"}],\"returned\":2},\"events\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/384/events\",\"items\":[],\"returned\":0}}]}}";

    @Rule
    public ActivityTestRule<ComicDetailActivity> mActivityTestRule = new ActivityTestRule<>(ComicDetailActivity.class, false, false);
    private CountingIdlingResource idlingResource;

    @Before
    public void setUp() {
        setUpInjection();
        mockResponse();
        launchActivity();
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
        setUpIdlingResource();
    }

    @Inject
    MarvelApi marvelApi;

    @Inject
    Gson gson;

    @Inject
    RxEspressoTransformer rxEspressoTransformer;

    private void setUpInjection() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        DefaultApplication app
                = (DefaultApplication) instrumentation.getTargetContext().getApplicationContext();
        TestComponent component = (TestComponent) app.appComponent;
        component.inject(this);
    }

    private void mockResponse() {
        ComicResponse response = gson.fromJson(mockComicResponse, ComicResponse.class);
        when(marvelApi.getComicById(any())).thenReturn(Observable.defer(() -> Observable.just(response).delay(1, TimeUnit.SECONDS).compose(rxEspressoTransformer.apply())));

    }

    private void launchActivity() {
        Intent i = new Intent();
        i.putExtra(ComicDetailActivity.COMIC_ID, "1");
        mActivityTestRule.launchActivity(i);
    }

    private void setUpIdlingResource() {
        idlingResource = new CountingIdlingResource(RxEspresso.TAG);
        Espresso.registerIdlingResources(idlingResource);
    }

    @Test
    public void showPrice() throws Exception {
        onView(allOf(withId(R.id.tvPrice), isDisplayed())).check(matches(isDisplayed()));
    }

    @Test
    public void showDescription() throws Exception {
        onView(allOf(withId(R.id.tvDescription), isDisplayed())).check(matches(isDisplayed()));
    }

    @Test
    public void showPage() throws Exception {
        onView(allOf(withId(R.id.tvPageCount), isDisplayed())).check(matches(isDisplayed()));
    }

    @Test
    public void showTitle() throws Exception {
        onView(allOf(withId(R.id.tvTitle), isDisplayed())).check(matches(isDisplayed()));
    }

    @Test
    public void showImage() throws Exception {
        onView(allOf(withId(R.id.sdv), isDisplayed())).check(matches(isDisplayed()));
    }

    @Test
    public void showAuthor() throws Exception {
        onView(allOf(withId(R.id.tvAuthor), isDisplayed())).check(matches(isDisplayed()));
    }


    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(idlingResource);
    }

    @AfterClass
    public static void tearDownClass() {
        RxAndroidPlugins.reset();
    }

}