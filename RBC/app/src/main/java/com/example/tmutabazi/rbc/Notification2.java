package com.example.tmutabazi.rbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Notification2 extends ActionBarActivity {

    private RadioGroup radioAddress;
    private RadioButton radiosameAddress;
    Button next2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   2 OUT 8");

        next2 = (Button) findViewById(R.id.next2);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radioAddress = (RadioGroup) findViewById(R.id.radioAddress);
                // get selected radio button from radioGroup
                int selectedId = radioAddress.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radiosameAddress = (RadioButton) findViewById(selectedId);

                Toast.makeText(Notification2.this,
                        radiosameAddress.getText(), Toast.LENGTH_SHORT).show();
                if(radiosameAddress.getText().equals("No"))
                {
                    Intent ip = new Intent(Notification2.this, PermanentAddress.class);
                    ip.putExtra("Activity", "notification2");
                    startActivity(ip);
                }
                else {
                    Intent ip = new Intent(Notification2.this, Notification3.class);
                    startActivity(ip);
                }



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification2, menu);
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
