package com.atasoyh.appbusinesstestproject.api;

import com.atasoyh.appbusinesstestproject.model.ComicResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by atasoyh on 29/06/2017.
 */

public interface MarvelApi {

//    final String API_LEVEL="v1";
//    final String API_URL=API_URL

    @GET("/v1/public/comics")
    ComicResponse getComics();

    @GET("/v1/public/comics/{comicId}")
    ComicResponse getComicById(@Path("comicId") String comicId);

}
