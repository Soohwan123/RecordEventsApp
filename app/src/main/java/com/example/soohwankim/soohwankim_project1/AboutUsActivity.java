package com.example.soohwankim.soohwankim_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AboutUsActivity extends AppCompatActivity {

    ArrayList<String> eventArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        findViewById(R.id.btnBackToMenu);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            eventArrayList = getIntent().getExtras().getStringArrayList("array");
        }
        else{
            eventArrayList = new ArrayList<String>();
        }
    }
    public void onClick(View view){
        Intent intent1 = new Intent(this, MenuActivity.class);
        intent1.putExtra("array", eventArrayList);
        startActivity(intent1);
        overridePendingTransition(
                android.R.anim.fade_in, android.R.anim.fade_out);
    }
}