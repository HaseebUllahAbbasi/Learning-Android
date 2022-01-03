package com.dot.smssender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class BroadCastReceiver extends BroadcastReceiver
{
    public static String SMS_BUNDLE = "pdus";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if(intent.getAction().equalsIgnoreCase("android.provider.Telephony.RECEiVED_SMS"))
        {
            if(bundle!=null)
            {
                Object[] sms = (Object[]) bundle.get(SMS_BUNDLE);
                String smsMsg = "";

                for (int i = 0; i <sms.length ; i++)
                {


                    String format = bundle.getString("format");
                    SmsMessage smsMessage = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        smsMessage = SmsMessage.createFromPdu( (byte[]) sms[i],format);
                    }
                    else
                        smsMessage = SmsMessage.createFromPdu( (byte[]) sms[i]);

                    String msgBody = smsMessage.getMessageBody().toString();
                    String msgAddress = smsMessage.getOriginatingAddress();
                    smsMsg+= "SMS from : "+ msgAddress;
                    smsMsg+= "body  : "+ msgBody;

                }
                MainActivity instance = MainActivity.Instance();
                instance.updateList(smsMsg);
            }
        }
    }
}
