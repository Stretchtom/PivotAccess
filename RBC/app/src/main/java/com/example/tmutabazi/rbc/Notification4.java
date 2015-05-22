package com.example.tmutabazi.rbc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Notification4 extends ActionBarActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    Button next4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifcation4);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   4 OUT 8");

        spinner1 = (Spinner)findViewById(R.id.zeroToseven);
        spinner2 = (Spinner)findViewById(R.id.eightTofourteen);
        spinner3 = (Spinner)findViewById(R.id.fifteentwentyone);
        spinner4 = (Spinner)findViewById(R.id.twentyonefortytwo);
        spinner5 = (Spinner)findViewById(R.id.fortytwoabove);
        spinner1.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner2.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner3.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner4.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner5.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));

        next4 = (Button) findViewById(R.id.next4);

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(Notification4.this, Notification5.class);
                startActivity(ip);



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notifcation4, menu);
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
