package com.atasoyh.appbusinesstestproject.interactor.db.mapper;

import com.atasoyh.appbusinesstestproject.interactor.db.model.ComicModel;
import com.atasoyh.appbusinesstestproject.model.Comic;



public class Mapper {

    public static ComicModel mapCharacterResponseToCharacter(Comic comic) {
        ComicModel comicModel = new ComicModel();

        comicModel.setTitle(comic.getTitle());
        comicModel.setDescription(comic.getDescription());
        comicModel.setThumbnail(String.format("%s/%s.%s",
                comic.getThumbnail().getPath(),
                ".",
                comic.getThumbnail().getExtension()));
        comicModel.setAuthor("-");
        comicModel.setPrice(comic.getPrices().toString());

        return comicModel;
    }
}
