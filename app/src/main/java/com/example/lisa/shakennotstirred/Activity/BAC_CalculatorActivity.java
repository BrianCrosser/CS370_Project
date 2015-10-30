package com.example.lisa.shakennotstirred.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lisa.shakennotstirred.Model.CalculatorModel;
import com.example.lisa.shakennotstirred.R;

public class BAC_CalculatorActivity extends Activity {
    private Spinner genderSpinner;
    private Spinner weightSpinner;
    CalculatorModel calculatorModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac__calculator);

        genderSpinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genders_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        genderSpinner.setAdapter(adapter);
        calculatorModel.getGender(genderSpinner.getSelectedItem().toString());

        weightSpinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.weights_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        weightSpinner.setAdapter(adapter1);
        calculatorModel.setWeight(weightSpinner.getSelectedItem().toString());

        Button addShotButton = (Button) findViewById(R.id.button6);
        addShotButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {calculatorModel.addShot();}
        });

        Button subShotButton = (Button) findViewById(R.id.button7);
        subShotButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {calculatorModel.subShot();}
        });

        Button addWineButton = (Button) findViewById(R.id.button9);
        addWineButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {calculatorModel.addWine();}
        });

        Button subWineButton = (Button) findViewById(R.id.button8);
        subWineButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {calculatorModel.subWine();}
        });

        Button addBeerButton = (Button) findViewById(R.id.button11);
        addBeerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {calculatorModel.addBeer();}
        });

        Button subBeerButton = (Button) findViewById(R.id.button10);
        subBeerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {calculatorModel.subBeer();}
        });
    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bac__calculator, menu);
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
