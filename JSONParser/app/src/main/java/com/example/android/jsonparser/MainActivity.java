package com.example.android.jsonparser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getContacts(View view){
        Intent intent = new Intent(MainActivity.this, ActivityAPI.class);
        startActivity(intent);
    }
    public void getCampaign(View view){
        Intent intent = new Intent(MainActivity.this, ActivityGetCampaign.class);
        startActivity(intent);
    }
}
