package com.example.tmutabazi.rbc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Notification6 extends ActionBarActivity {

    Button next6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification6);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   6 OUT 8");

        next6 = (Button) findViewById(R.id.next6);

        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(Notification6.this, Notification7.class);
                startActivity(ip);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification6, menu);
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
