package com.example.lisa.shakennotstirred.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lisa.shakennotstirred.R;
import com.example.lisa.shakennotstirred.adapters.DrinkRecipeListAdapter;
import com.example.lisa.shakennotstirred.models.SearchResultModel;
import com.example.lisa.shakennotstirred.services.APIClient;

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
