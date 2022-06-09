package com.example.soohwankim.soohwankim_project1;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity {
    private static final String TAG = "AddEventActivity";

    String dbDate;
    String dbTime;
    DatePickerDialog.OnDateSetListener mDateSetListener;

    EditText editDate;
    ImageView cal;
    TimePicker timePicker;
    EditText medNameText;

    ArrayList<String> eventArrayList;

    //for calendar
    private int mDate, mMonth, mYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        timePicker = findViewById(R.id.clock);
        medNameText  = findViewById(R.id.medName);
        editDate = findViewById(R.id.date);
        cal = findViewById(R.id.datepicker);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            eventArrayList = getIntent().getExtras().getStringArrayList("array");
        }
        else{
            eventArrayList = new ArrayList<String>();
        }


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar Cal = Calendar.getInstance();
                mDate = Cal.get(Calendar.DATE);
                mMonth = Cal.get(Calendar.MONTH);
                mYear = Cal.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddEventActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                                editDate.setText(date + "-" + month + "-" + year);
                                dbDate = month + "/" + date + "/" + year;
                            }
                        }, mYear, mMonth, mDate);
                datePickerDialog.show();
            }
        });



    }

    public void onClickAddEvent(View view){
        int count = 0;
        int hourTemp;
        int minTemp;
        hourTemp = timePicker.getHour();
        minTemp = timePicker.getMinute();
        dbTime = hourTemp + ":" + minTemp;


        eventArrayList.add(dbDate + "\n" + dbTime + "\n" + medNameText.getText().toString());

        Toast.makeText(getApplicationContext(), "An event has been made!", Toast.LENGTH_LONG).show();
    }


    public void onClick(View view){
        Intent intent1 = new Intent(this, MenuActivity.class);

        intent1.putExtra("array", eventArrayList);
        startActivity(intent1);
    }
}

