package com.example.lisa.shakennotstirred.providers;

import com.example.lisa.shakennotstirred.models.SearchResultModel;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Lisa on 10/28/15.
 */
public interface IDrinkRecipeProvider {
    //search by name of cocktail
    @GET ("/api/json/v1/1/search.php")
    Observable<SearchResultModel> getDrinkRecipesByIngredient (@Query("s") String ingredient);

    @GET("api/json/v1/1/random.php")
    Observable<SearchResultModel> getRandomDrinkRecipe();
}
