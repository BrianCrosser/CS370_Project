package com.example.lisa.shakennotstirred.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lisa on 10/28/15.
 */
public class SearchResultModel {
    @SerializedName("drinks")
    ArrayList<DrinkRecipeModel> searchResults;

    public ArrayList<DrinkRecipeModel> getSearchResults(){
        return searchResults;
    }

    public void setSearchResults(ArrayList<DrinkRecipeModel> searchResults){
        this.searchResults = searchResults;
    }
}
