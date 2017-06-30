package com.atasoyh.appbusinesstestproject.interactor.db;

import com.atasoyh.appbusinesstestproject.interactor.db.model.ComicModel;

import java.sql.SQLException;
import java.util.List;


public interface DatabaseHelper {

    int addCharacter(ComicModel character) throws SQLException;

    List<ComicModel> selectAllComics() throws SQLException;

}
