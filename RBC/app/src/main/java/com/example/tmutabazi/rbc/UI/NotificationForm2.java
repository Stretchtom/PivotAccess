package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class NotificationForm2 extends ActionBarActivity implements View.OnClickListener{

    private EditText DOB;
    private EditText age;
    private EditText nationality;
    private EditText phoneNumber;
    private RadioGroup pregnant;
    private RadioButton pregnantSelected;
    private RadioGroup sameAddress;
    private RadioButton sameAddressSelected;
    Notification notification;
    Button next2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   2 OUT 8");

        Intent i = getIntent();
        final String firstName = i.getStringExtra("firstName");
        final String surName = i.getStringExtra("surname");
        final String gender = i.getStringExtra("gender");
        notification = (Notification) i.getSerializableExtra("object");
        DOB = (EditText) findViewById(R.id.DOB);
        DOB.setOnClickListener(this);


        Toast.makeText(NotificationForm2.this,
                notification.getDate(), Toast.LENGTH_SHORT).show();
        next2 = (Button) findViewById(R.id.next2);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objectBuilding(notification);

                age = (EditText) findViewById(R.id.age);
                nationality = (EditText) findViewById(R.id.nationality);
                phoneNumber = (EditText) findViewById(R.id.phoneNumber);
                notification.setPatientInformation(firstName,surName,gender,nationality.getText().toString(),Integer.parseInt(age.getText().toString()),Integer.parseInt(phoneNumber.getText().toString()),DOB.getText().toString());


                if(notification.getSameAddress().equals("Yes"))
                {
                    Intent ip = new Intent(NotificationForm2.this, PermanentAddress.class);
                    ip.putExtra("Activity", "notification2");
                    ip.putExtra("object",  notification);
                    startActivity(ip);
                }
                else {
                    Intent ip = new Intent(NotificationForm2.this, NotificationForm3.class);
                    ip.putExtra("object",  notification);
                    startActivity(ip);
                }



            }
        });
    }

    public Notification objectBuilding(Notification notification)
    {

      pregnant = (RadioGroup) findViewById(R.id.radioPregnant);
      pregnantSelected = (RadioButton) findViewById(pregnant.getCheckedRadioButtonId());
        notification.setPregnancy(pregnantSelected.getText().toString());
      sameAddress = (RadioGroup) findViewById(R.id.radioAddress);
      sameAddressSelected = (RadioButton) findViewById(sameAddress.getCheckedRadioButtonId());
        notification.setSameAddress(sameAddressSelected.getText().toString());
        return notification;
    }

    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePicker = new DatePickerDialog(NotificationForm2.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                DOB.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }

        }, year, month, day);
        datePicker.show();
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
