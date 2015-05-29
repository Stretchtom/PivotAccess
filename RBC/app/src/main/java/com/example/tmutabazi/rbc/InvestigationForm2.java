package com.example.tmutabazi.rbc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class InvestigationForm2 extends ActionBarActivity {
    private Button next;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form2);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    2 OUT OF 5");
        next = (Button) findViewById(R.id.button2);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ip = new Intent(InvestigationForm2.this, InvestigationForm3.class);
                //startActivity(ip);


                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                Log.d("selectedID", selectedId + "HERE");

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);
                Log.d("selectedID", selectedId + "HERE");
                Toast.makeText(InvestigationForm2.this,
                        radioSexButton.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form2, menu);
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
