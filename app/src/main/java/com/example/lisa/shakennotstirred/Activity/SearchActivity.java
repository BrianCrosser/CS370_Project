package com.example.lisa.shakennotstirred.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lisa.shakennotstirred.R;
import com.example.lisa.shakennotstirred.adapters.DrinkRecipeListAdapter;
import com.example.lisa.shakennotstirred.models.DrinkRecipeModel;
import com.example.lisa.shakennotstirred.models.SearchResultModel;
import com.example.lisa.shakennotstirred.services.APIClient;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends Activity {

    private ListView ListView1;
    private Button searchButton;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView1 = (ListView) findViewById(R.id.ListView1);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchInput = (EditText) findViewById(R.id.searchInput);

        searchInput.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        ListView1.setBackgroundColor(Color.LTGRAY);

        searchInput.getBackground().setAlpha(200);
        searchButton.getBackground().setAlpha(200);
        ListView1.getBackground().setAlpha(200);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIClient.getRecipeProvider()
                        .getDrinkRecipesByIngredient(searchInput.getText().toString())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<SearchResultModel>() {

                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                int i = 0;
                            }

                            @Override
                            public void onNext(SearchResultModel searchResultModel) {
                                ListView1.setAdapter(new DrinkRecipeListAdapter(SearchActivity.this, searchResultModel.getSearchResults()));

                            }
                        });
            }
        });

        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                DrinkRecipeModel value = (DrinkRecipeModel) ListView1.getItemAtPosition(position);
                // selected item
                String cocktail = value.getDrinkName();
                String cocktailImage = value.getDrinkThumb();
                String instructions = value.getInstructions();
                ArrayList<String> ingredients = value.getIngredients();

                Intent myIntent = new Intent(getApplicationContext(), CocktailDisplay.class);
                // sending data to new activity
                Bundle extras = new Bundle();
                extras.putString("cocktail-name", cocktail);
                extras.putString("cocktail-image", cocktailImage);
                extras.putString("cocktail-instr", instructions);
                extras.putStringArrayList("ingredient-list", ingredients);
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
