
package com.atasoyh.appbusinesstestproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicPrice {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("price")
    @Expose
    private double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
