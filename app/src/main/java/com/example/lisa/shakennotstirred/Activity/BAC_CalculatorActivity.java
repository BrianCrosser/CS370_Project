package com.example.lisa.shakennotstirred.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lisa.shakennotstirred.R;
import com.example.lisa.shakennotstirred.models.CalculatorModel;

public class BAC_CalculatorActivity extends Activity {

    public Spinner genderSpinner;
    public EditText WeightEdit;
    public Button weightbutton;
    public Button addShotButton;
    public Button subShotButton;
    public Button addWineButton;
    public Button subWineButton;
    public Button addBeerButton;
    public Button subBeerButton;
    public Button button;
    public TextView textView9;
    public TextView textView10;
    public TextView textView11;

    CalculatorModel calculatorModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_calculator);

        genderSpinner = (Spinner) findViewById(R.id.spinner);
        WeightEdit = (EditText) findViewById(R.id.WeightEdit);
        weightbutton = (Button) findViewById(R.id.weightButton);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10= (TextView) findViewById(R.id.textView10);
        textView11= (TextView) findViewById(R.id.textView11);
        addShotButton = (Button) findViewById(R.id.button6);
        subShotButton = (Button) findViewById(R.id.button7);
        addWineButton = (Button) findViewById(R.id.button9);
        subWineButton = (Button) findViewById(R.id.button8);
        addBeerButton = (Button) findViewById(R.id.button11);
        subBeerButton = (Button) findViewById(R.id.button10);
        button = (Button) findViewById(R.id.button);

        calculatorModel = new CalculatorModel();

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genders_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        genderSpinner.setAdapter(adapter);
        calculatorModel.getGender(genderSpinner.getSelectedItem().toString());

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.weights_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner


        //weightSpinner.setAdapter(adapter1);
        //calculatorModel.setWeight(weightSpinner.getSelectedItem().toString());

        weightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightValue = WeightEdit.getText().toString();
                calculatorModel.setWeight(weightValue);
            }
        });


        addShotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adds 1 to the counter
                calculatorModel.addShot();
                textView9.setText(String.valueOf(calculatorModel.getShotCount()));
            }
        });

        subShotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Subtracts 1 from the counter
                calculatorModel.subShot();
                textView9.setText(String.valueOf(calculatorModel.getShotCount()));
            }
        });

        addWineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.addWine();
                textView10.setText(String.valueOf(calculatorModel.getWineCount()));
            }
        });

        subWineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.subWine();
                textView10.setText(String.valueOf(calculatorModel.getWineCount()));
            }
        });

        addBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.addBeer();
                textView11.setText(String.valueOf(calculatorModel.getBeerCount()));
            }
        });

        subBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.subBeer();
                textView11.setText(String.valueOf(calculatorModel.getBeerCount()));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorModel.getBAC(String.valueOf(calculatorModel.getGender(genderSpinner.getSelectedItem().toString())));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bac_calculator, menu);
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
