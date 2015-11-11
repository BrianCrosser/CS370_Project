package com.example.lisa.shakennotstirred.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.lisa.shakennotstirred.R;
import com.example.lisa.shakennotstirred.models.DrinkRecipeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lisa on 10/28/15.
 */
public class DrinkRecipeListAdapter extends ArrayAdapter<DrinkRecipeModel>{
    public DrinkRecipeListAdapter (Context context, ArrayList<DrinkRecipeModel> recipes) {
        super(context, 0, recipes);
    }

    public DrinkRecipeListAdapter(Context context, int resource, List<DrinkRecipeModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.recipe_item, null);
        }

        DrinkRecipeModel recipe = getItem(position);

        if (recipe != null) {
           // TextView nameText = (TextView) v.findViewById(R.id.nameText);
            ImageView icon = (ImageView) v.findViewById(R.id.cocktailThumb);

            if (icon != null){
                Picasso.with(getContext()).load(recipe.drinkThumb).resize(200,200).into(icon);
            }
//            if (nameText != null) {
//                nameText.setText(recipe.getDrinkName());
//            }
        }
        return v;

    }
}
