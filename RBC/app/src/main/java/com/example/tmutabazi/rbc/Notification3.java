package com.example.tmutabazi.rbc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.TimeZone;


public class Notification3 extends ActionBarActivity implements View.OnClickListener{
    private EditText date;
    private Spinner spinner;
    private EditText date1;
    Button next3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification3);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   3 OUT 8");
        date = (EditText) findViewById(R.id.illnessDate);
        date.setOnClickListener(this);
        date1 = (EditText) findViewById(R.id.editText6);
        date1.setOnClickListener(this);
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

    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(Notification3.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                switch (v.getId()) {
                    case R.id.illnessDate:
                        date.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.editText6:
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;

                    //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                }
            }
        }, year, month, day);
        datePicker.show();




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
