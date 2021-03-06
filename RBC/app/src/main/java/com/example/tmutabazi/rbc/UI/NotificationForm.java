package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class NotificationForm extends ActionBarActivity implements View.OnClickListener{
    private EditText date;
    private Button next1;
    private EditText case_no;
    private RadioGroup patient_type;
    private RadioButton patient_typeSelected;
    private RadioGroup refered;
    private RadioButton referedSelected;
    private EditText firstName;
    private EditText surname;
    private RadioGroup gender;
    private RadioButton genderSelected;
    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   1 OUT 8");

        ArrayList tExp = new ArrayList();
        for(int i=1;i<=50;i++)
        {
            tExp.add(i);
        }
        tExp.add(0,"Select One");
        Spinner sp = (Spinner) findViewById(R.id.village);
        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,R.layout.spinner,tExp);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(NotificationForm.this, "Here it is selected",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        next1 = (Button) findViewById(R.id.next1);
        date = (EditText) findViewById(R.id.notification_date);
        date.setOnClickListener(this);
        refered = (RadioGroup) findViewById(R.id.radioRefered);
        patient_type = (RadioGroup) findViewById(R.id.radioPatient);



        patient_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioInpatient) {
                    for (int i = 0; i < refered.getChildCount(); i++) {
                        refered.getChildAt(i).setEnabled(true);
                    }
                } else if (checkedId == R.id.radioOutpatient) {
                    for (int i = 0; i < refered.getChildCount(); i++) {
                        refered.getChildAt(i).setEnabled(false);
                    }
                }


            }
        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = new Notification();
               notification = objectBuilding(notification);

                firstName = (EditText) findViewById(R.id.fName);
                surname = (EditText) findViewById(R.id.sName);
                gender = (RadioGroup) findViewById(R.id.radioSex);
                genderSelected = (RadioButton) findViewById(gender.getCheckedRadioButtonId());




                Intent ip = new Intent(NotificationForm.this, NotificationForm8.class);
                ip.putExtra("firstName",firstName.getText().toString());
                ip.putExtra("surname", surname.getText());
                ip.putExtra("gender", genderSelected.getText().toString());
                ip.putExtra("object", notification);

                startActivity(ip);



            }
        });
    }
    public Notification objectBuilding(Notification notification)
    {


        notification.setDate(date.getText().toString());
        case_no = (EditText) findViewById(R.id.CaseCode);
        notification.setCaseNumber(Integer.parseInt(case_no.getText().toString()));
        patient_typeSelected = (RadioButton) findViewById(patient_type.getCheckedRadioButtonId());
        notification.setStatusPatient(patient_typeSelected.getText().toString());
        if(patient_typeSelected.getText().toString().equals("In patient"))
        {
            referedSelected = (RadioButton) findViewById(refered.getCheckedRadioButtonId());
            notification.setRefered(referedSelected.getText().toString());
        }

        return notification;

    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        DatePickerDialog datePicker=new DatePickerDialog(NotificationForm.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_notification, menu);
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
