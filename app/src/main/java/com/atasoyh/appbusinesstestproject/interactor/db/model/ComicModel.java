package com.atasoyh.appbusinesstestproject.interactor.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


@DatabaseTable(tableName = ComicModel.TABLE_NAME_COMICS, daoClass = ComicDao.class)
public class ComicModel implements Serializable {
    public static final String TABLE_NAME_COMICS = "comics";
    public static final String FIELD_COMIC_ID = "_id";
    public static final String FIELD_COMIC_DESCRIPTION = "description";
    public static final String FIELD_COMIC_THUMBNAIL = "thumbnail";
    public static final String FIELD_COMIC_AUTHOR = "author";
    public static final String FIELD_COMIC_PRICE = "price";
    public static final String FIELD_COMIC_TITLE = "title";


    @DatabaseField(generatedId = true, columnName = FIELD_COMIC_ID)
    private int id;
    @DatabaseField(columnName = FIELD_COMIC_DESCRIPTION)
    private String description;
    @DatabaseField(columnName = FIELD_COMIC_THUMBNAIL)
    private String thumbnail;
    @DatabaseField(columnName = FIELD_COMIC_AUTHOR)
    private String author;
    @DatabaseField(columnName = FIELD_COMIC_PRICE)
    private String price;
    @DatabaseField(columnName = FIELD_COMIC_TITLE)
    private String title;

    public ComicModel() {
    }

    public ComicModel(int id, String title, String author, String description, String thumbnail, String price) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}