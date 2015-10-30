package com.example.lisa.shakennotstirred.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lisa.shakennotstirred.activity.BAC_CalculatorActivity;
import com.example.lisa.shakennotstirred.R;


public class MainActivity extends Activity {

    Button button1;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BAC_CalculatorActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inventory.class);
                startActivityForResult(intent, 0);
            }
        });

    }

}

    /*
        public void onClick(View v) {

        }

    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button1:
                button1Click();
                break;

        }
    }
    public void button1Click(){
        startActivity(new Intent(".SearchActivity"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
*/