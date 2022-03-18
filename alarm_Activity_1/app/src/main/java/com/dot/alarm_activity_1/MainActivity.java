package com.dot.alarm_activity_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker =  findViewById(R.id.timePicker);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setAlarm(View view)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),timePicker.getHour(),timePicker.getMinute(),0);
        setAlaramMethod(calendar.getTimeInMillis());

    }

    private void setAlaramMethod(long timeInMillis)
    {
        AlarmManager alarmManager =  (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1234,intent,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,timeInMillis,pendingIntent);
    }
}