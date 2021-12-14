package com.dot.lab_8_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EndService(View view)
    {
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        stopService(serviceIntent);

    }

    public void startService(View view) {
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android ");
        ContextCompat.startForegroundService(this,serviceIntent);
    }
}