package com.example.soohwankim.soohwankim_project1;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewManager;
    TextView textViewDisplay;
    ArrayList<String> backupArrayList;
    // define in class
/*    private DBAdapter db;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        recyclerView = findViewById( R.id.recyclerView );
        textViewDisplay = findViewById( R.id.textViewDisplay);
        recyclerViewManager = new LinearLayoutManager( getApplicationContext() );
        recyclerView.setLayoutManager( recyclerViewManager );
        recyclerView.setHasFixedSize( true );

        Bundle extras = getIntent().getExtras();
        if(extras.getStringArrayList("array") != null){
            ArrayList<String> array = extras.getStringArrayList("array");
            if(array.isEmpty()){
                backupArrayList = new ArrayList<String>();
            }
            else{
                backupArrayList = getIntent().getExtras().getStringArrayList("array");
            }
        }
        else{
            backupArrayList = new ArrayList<String>();
        }


        recyclerViewAdapter = new AnotherAdaptor( getApplicationContext(), backupArrayList );
        recyclerView.setAdapter( recyclerViewAdapter );
    }


    public void onButtonClick(View view) {
        switch (view.getId())
        {
            case R.id.btnRemoveAll:
                backupArrayList.clear();
                recyclerViewAdapter = new AnotherAdaptor( getApplicationContext(), backupArrayList );
                recyclerView.setAdapter( recyclerViewAdapter );
                break;
            case R.id.btnRemoveLast:
                backupArrayList.remove(backupArrayList.size()-1);
                recyclerViewAdapter = new AnotherAdaptor( getApplicationContext(), backupArrayList );
                recyclerView.setAdapter( recyclerViewAdapter );
                break;
            case R.id.btnFromRecToMain:
                Intent intent1 = new Intent(this, MenuActivity.class);
                intent1.putExtra("array", backupArrayList);
                startActivity(intent1);
                break;

        }
    }
}