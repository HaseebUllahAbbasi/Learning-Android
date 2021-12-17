package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void activity2SendBroadcast(View view){
        Intent intent = new Intent();
        intent.setAction("nisarahmedsiddiqui");

        sendBroadcast(intent);
    }
}