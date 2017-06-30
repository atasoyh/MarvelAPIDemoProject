package com.atasoyh.appbusinesstestproject.interactor.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.atasoyh.appbusinesstestproject.R;
import com.atasoyh.appbusinesstestproject.interactor.db.model.ComicModel;
import com.atasoyh.appbusinesstestproject.model.Comic;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;


public class DatabaseHelperImpl extends OrmLiteSqliteOpenHelper implements DatabaseHelper {

    private static final String DATABASE_NAME = "marvel.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<ComicModel, Integer> comicDao;

    @Inject
    public DatabaseHelperImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        try {
            // Create tables. This onCreate() method will be invoked only once of the application life time i.e. the first time when the application starts.
            TableUtils.createTable(connectionSource, ComicModel.class);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to create database", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            TableUtils.dropTable(connectionSource, ComicModel.class, true);
            onCreate(sqliteDatabase, connectionSource);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
                    + newVer, e);
        }
    }

    public Dao<ComicModel, Integer> getComicDao() throws SQLException {
        if (comicDao == null) {
            comicDao = getDao(ComicModel.class);
        }
        return comicDao;
    }

    @Override
    public int addCharacter(ComicModel comic) throws SQLException {
        ComicModel result = getComicDao().queryForFirst(getComicDao()
                .queryBuilder()
                .where()
                .like(ComicModel.FIELD_COMIC_TITLE, comic.getTitle())
                .prepare());

        if (null != result)
            getComicDao().delete(result);

        return getComicDao().create(comic);
    }

    @Override
    public List<ComicModel> selectAllComics() throws SQLException {
        return getComicDao().query(getComicDao().queryBuilder().prepare());
    }

    // Close the database connections and clear any cached DAOs.
    @Override
    public void close() {
        super.close();
        comicDao = null;
    }
}
