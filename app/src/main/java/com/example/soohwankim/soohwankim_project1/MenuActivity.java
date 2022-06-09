package com.example.soohwankim.soohwankim_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> eventArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViewById(R.id.btnAddEvents).setOnClickListener(this);
        findViewById(R.id.btnPastEvents).setOnClickListener(this);
        findViewById(R.id.btnAboutUs).setOnClickListener(this);

// Get the extras (if there are any)
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            eventArrayList = getIntent().getExtras().getStringArrayList("array");
        }
        else{
            eventArrayList = new ArrayList<String>();
        }
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btnAddEvents:
                Intent intent1 = new Intent(this, AddEventActivity.class);
                intent1.putExtra("array", eventArrayList);
                startActivity(intent1);
                overridePendingTransition(
                        android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btnPastEvents:
                Intent intent2 = new Intent(this, RecordsActivity.class);
                intent2.putExtra("array", eventArrayList);
                startActivity(intent2);
                overridePendingTransition(
                        android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btnAboutUs:
                Intent intent3 = new Intent(this, AboutUsActivity.class);
                intent3.putExtra("array", eventArrayList);
                startActivity(intent3);
                overridePendingTransition(
                        android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}