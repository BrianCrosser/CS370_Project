package com.example.lisa.shakennotstirred.providers;

import com.example.lisa.shakennotstirred.models.DrinkRecipeModel;
import com.example.lisa.shakennotstirred.models.SearchResultModel;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Lisa on 10/28/15.
 */
public interface IDrinkRecipeProvider {
    @GET ("/api/json/v1/1/filter.php")
    Observable<SearchResultModel> getDrinkRecipesByIngredient (@Query("i") String ingredient);
}
