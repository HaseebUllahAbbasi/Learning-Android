package com.example.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMe(View view){
        //Step 1 - Create object of alarm manager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //Step 2 - Create a pending Intent
        Intent myReceiverIntent = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                1234,
                myReceiverIntent,
                0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, 1000 * 10, pendingIntent);

    }
}