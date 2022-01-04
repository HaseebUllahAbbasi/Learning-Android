package com.example.smsreaderlab9_2;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InComingSms extends BroadcastReceiver {
    // Get the object of SmsManager

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Recieved");
        //Toast.makeText(context.getApplicationContext(), "Intent recieved: " + intent.getAction(), Toast.LENGTH_SHORT).show();

        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[])bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                if (messages.length > -1) {
                    Toast.makeText(context.getApplicationContext(), messages[0].getOriginatingAddress()+" : " + messages[0].getMessageBody(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
