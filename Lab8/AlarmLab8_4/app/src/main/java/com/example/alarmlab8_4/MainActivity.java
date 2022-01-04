package com.example.alarmlab8_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker time;
    Button btnAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.timePicker);
        btnAlarm = findViewById(R.id.button);
    }
    public void createAlaram(View view)
    {
        //calender object to get time from timepicker in miliseconds , because calender doesnot give in ms
        Calendar calendar = Calendar.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    time.getHour(),
                    time.getMinute(),
                    0);
        }
        else
        {
            calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    time.getCurrentHour(),
                    time.getCurrentMinute(),
                    0);
        }

        setAlarm(calendar.getTimeInMillis());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(this, "Alarm is set to "+time.getHour()+" : "+time.getMinute(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Alarm is set to "+time.getCurrentHour()+" : "+time.getCurrentMinute(), Toast.LENGTH_SHORT).show();
        }
        time.setEnabled(false);
        btnAlarm.setEnabled(false);
    }

    private void setAlarm(long timeInMillis) {
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent myReciverintent = new Intent(this,MyReciever.class);
        PendingIntent intent = PendingIntent.getBroadcast(this, 1234, myReciverintent, 0);
        manager.set(AlarmManager.RTC_WAKEUP,timeInMillis,intent);

    }

}