package com.example.lisa.shakennotstirred.activity;

import com.example.lisa.shakennotstirred.models.DrinkRecipeModel;
import com.example.lisa.shakennotstirred.models.SearchResultModel;
import com.example.lisa.shakennotstirred.services.APIClient;
import com.example.lisa.shakennotstirred.adapters.DrinkRecipeListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import rx.schedulers.Schedulers;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;



import java.util.ArrayList;

import com.example.lisa.shakennotstirred.R;

public class SearchActivity extends Activity {

    private ListView ListView1;
    private Button searchButton;
    private EditText searchInput;
    SearchView sv;

  //  String[] alcohols= {"Rum", "Gin", "Brandy", "Tequila", "Vodka", "Whiskey", "Mezcal", "Pisco"};
  //  ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        ListView1 = (ListView) findViewById(R.id.ListView1);
        // sv = (SearchView) findViewById(R.id.searchView1);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchInput = (EditText) findViewById(R.id.searchInput);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SearchResultModel model = createMock()
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
