package com.example.lisa.shakennotstirred.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lisa.shakennotstirred.R;
import com.example.lisa.shakennotstirred.models.DrinkRecipeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CocktailDisplay extends Activity {
    TextView cocktailName;
    TextView ingredient;
    TextView instructionString;
    ImageView cocktailImage;
    ListView ingredients;

    DrinkRecipeModel recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_display);

        ingredient = (TextView) findViewById(R.id.ingredient);
        cocktailName = (TextView) findViewById(R.id.cocktailName);
        cocktailImage = (ImageView) findViewById(R.id.cocktailImage);
        ingredients = (ListView) findViewById(R.id.ingredients);
        instructionString = (TextView) findViewById(R.id.instructionString);

        ingredients.setBackgroundColor(Color.LTGRAY);

        ingredients.getBackground().setAlpha(200);

        // get the intent from which this activity is called.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        // fetch value from key-value pair and make it visible on TextView.

        String cocktail_Name = extras.getString("cocktail-name");
        String cocktail_Image = extras.getString("cocktail-image");
        String cocktail_instr = extras.getString("cocktail-instr");
        ArrayList<String> cocktail_Ingredients = extras.getStringArrayList("ingredient-list");


        if (cocktailName != null) {
            cocktailName.setText(cocktail_Name);
            instructionString.setText(cocktail_instr);
            Picasso.with(getBaseContext()).load(cocktail_Image).into(cocktailImage);
        }

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CocktailDisplay.this, android.R.layout.simple_list_item_1, recipe.getIngredients());
        //ingredients.setAdapter(arrayAdapter);

        //ingredients.setAdapter(new DrinkRecipeListAdapter(DrinkRecipeModel.this, recipe.getIngredients()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cocktail_display, menu);
        return true;
    }

}