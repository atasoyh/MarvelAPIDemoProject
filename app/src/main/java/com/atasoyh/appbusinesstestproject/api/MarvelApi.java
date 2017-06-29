package com.atasoyh.appbusinesstestproject.api;

import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface MarvelApi {

    final static String API_URL="https://gateway.marvel.com:443";

    @GET("/v1/public/comics")
    Observable<ComicResponse> getComics(@Query("offset") int offset,@Query("limit") int limit);

    @GET("/v1/public/comics")
    Observable<ComicResponse> getComics();

    @GET("/v1/public/comics/{comicId}")
    Observable<ComicResponse> getComicById(@Path("comicId") String comicId);

}
