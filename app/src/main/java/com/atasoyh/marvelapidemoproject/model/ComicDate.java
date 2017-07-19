
package com.atasoyh.marvelapidemoproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicDate {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
