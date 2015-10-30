package com.example.lisa.shakennotstirred.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Lisa on 10/28/15.
 */
public class DrinkRecipeModel {
    @SerializedName("idDrink")
    private int drinkId;

    @SerializedName("strDrink")
    private String drinkName;

    @SerializedName("categories")
    private String drinkCategories;

    @SerializedName("ingredients")
    private ArrayList<String> ingredients;

//    private boolean isAlcoholic;
//    private String instructions;
//    //private URI thumb;

//    private String[] ingredientMeasurements;


    public int getDrinkId() {
        return drinkId;
    }

    public String getDrinkName(){
        return drinkName;
    }

    public String getDrinkCategories(){
        return drinkCategories;
    }

    public ArrayList<String> getIngredients() { return ingredients; }


    public void setDrinkId(int drinkId) { this.drinkId = drinkId; }

    public void setDrinkName(String drinkName) { this.drinkName = drinkName; }

    public void setDrinkCategories(String drinkCategories) {
        this.drinkCategories = drinkCategories;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }
}
