package com.atasoyh.appbusinesstestproject.interactor.db.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

import java.sql.SQLException;
import java.util.List;


public class ComicDao extends BaseDaoImpl<ComicModel, Integer> {

    public ComicDao(Class<ComicModel> dataClass) throws SQLException {
        super(dataClass);
    }

    public ComicDao(ConnectionSource connectionSource, Class<ComicModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public ComicDao(ConnectionSource connectionSource, DatabaseTableConfig<ComicModel> tableConfig) throws SQLException {
        super(connectionSource, tableConfig);
    }

    public List<ComicModel> getCharacters() throws SQLException {
        return queryForAll();
    }

}
