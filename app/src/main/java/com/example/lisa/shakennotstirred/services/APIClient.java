package com.example.lisa.shakennotstirred.services;

import com.example.lisa.shakennotstirred.AppDefines;
import com.example.lisa.shakennotstirred.providers.IDrinkRecipeProvider;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Lisa on 10/28/15.
 */
public class APIClient {
    private static com.example.lisa.shakennotstirred.providers.IDrinkRecipeProvider drinkRecipeProvider;

    public static IDrinkRecipeProvider getRecipeProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppDefines.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        drinkRecipeProvider = retrofit.create(IDrinkRecipeProvider.class);

        return drinkRecipeProvider;
    }
}
