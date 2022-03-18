package com.dot.work_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    SensorManager manager;
    Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null)
        {
            sensor  = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        }
        else
        {
            Log.d(TAG, "onCreate: not available");
        }
//        OneTimeWorkRequest oneTimeRequest = new OneTimeWorkRequest.Builder(UploadWorker.class).build();
//
//
//        WorkManager instance = WorkManager.getInstance(getApplicationContext());
//        instance.enqueue(oneTimeRequest);
//
//        Operation sendReq = instance.enqueueUniqueWork("sendReq", ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) oneTimeRequest);




    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        Log.d(TAG, "onSensorChanged: "+sensorEvent.values[0]);
        Log.d(TAG, "onSensorChanged: "+sensorEvent.values[1]);
        Log.d(TAG, "onSensorChanged: "+sensorEvent.values[2]);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }
}