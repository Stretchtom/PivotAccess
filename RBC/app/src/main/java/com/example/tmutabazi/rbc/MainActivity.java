package com.example.tmutabazi.rbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button notification;
    Button investigation;
    private android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        notification = (Button) findViewById(R.id.notification);
        investigation = (Button) findViewById(R.id.investigation);
        actionBar = getSupportActionBar();


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(MainActivity.this, Notification.class);
                startActivity(ip);
            }
        });
=======

        Intent ip = new Intent(MainActivity.this, InvestigationForm.class);
        startActivity(ip);

    }
>>>>>>> origin/master

        investigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(MainActivity.this, InvestigationForm.class);
                startActivity(ip);
            }
        });

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
