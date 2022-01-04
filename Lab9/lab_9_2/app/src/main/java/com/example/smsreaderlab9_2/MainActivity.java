package com.example.smsreaderlab9_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    InComingSms sms= new InComingSms();;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        filter.addCategory("android.provider.category.DEFAULT");
        filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);

        System.out.println(sms + " "+ filter);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{(Manifest.permission.RECEIVE_SMS)},10);
        registerReceiver(sms, filter);
    }
}