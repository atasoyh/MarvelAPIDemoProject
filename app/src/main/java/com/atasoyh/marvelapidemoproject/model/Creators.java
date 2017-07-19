
package com.atasoyh.marvelapidemoproject.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Creators {

    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("returned")
    @Expose
    private String returned;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<CreatorSummary> creatorSummaries = null;

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<CreatorSummary> getCreatorSummaries() {
        return creatorSummaries;
    }

    public void setCreatorSummaries(List<CreatorSummary> creatorSummaries) {
        this.creatorSummaries = creatorSummaries;
    }

}
