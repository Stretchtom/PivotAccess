package com.example.tmutabazi.rbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Notification3 extends ActionBarActivity {

    private Spinner spinner;
    Button next3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification3);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   3 OUT 8");

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.frequency, R.layout.spinner));

        next3 = (Button) findViewById(R.id.next3);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(Notification3.this, Notification4.class);
                startActivity(ip);



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification3, menu);
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
