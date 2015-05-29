package com.example.tmutabazi.rbc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm extends ActionBarActivity implements View.OnClickListener {
    private Button next;
    private EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    1 OUT OF 6");
        next = (Button) findViewById(R.id.button);
        date = (EditText) findViewById(R.id.editText);
        date.setOnClickListener(this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(InvestigationForm.this, InvestigationForm2.class);
                startActivity(ip);

            }
        });
    }

    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




                DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker.show();




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form1, menu);
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
