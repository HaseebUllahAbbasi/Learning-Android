 package com.dot.smssender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.net.URI;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

 public class MainActivity extends AppCompatActivity {

     EditText number;
     EditText message;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity  =  this;
        setContentView(R.layout.activity_main);
        number =  findViewById(R.id.number);
        message =   findViewById(R.id.message);
         if(checkPermission(Manifest.permission.SEND_SMS))
         {

         }
         else
         {
             ActivityCompat.requestPermissions(this,new String[]{
                     (Manifest.permission.SEND_SMS)},123 );
         }
         listViewSMS = (ListView) findViewById(R.id.messagesList);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,smsList);
        listViewSMS.setAdapter(arrayAdapter);
        if(checkPermission(Manifest.permission.READ_SMS))
        {
            Refresh();
        }
        else
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{(Manifest.permission.READ_SMS)},124);
        }

    }
    public void sendMessage(View show)
    {
        String number_string = number.getText().toString();
        String message_string = message.getText().toString();
        SmsManager smsManager  = SmsManager.getDefault();
        smsManager.sendTextMessage(number_string,null,message_string,null,null);
        Log.d(TAG, "sendMessage:  sent");


    }
    public boolean checkPermission (String permission)
    {
        int checkPermission  = ContextCompat.checkSelfPermission(this,permission);
        return checkPermission == PackageManager.PERMISSION_GRANTED;
    }
     ArrayList<String> smsList = new ArrayList<>();
     ListView listViewSMS ;

     ArrayAdapter arrayAdapter;
     static MainActivity  mainActivity;
     public void showMessages()
    {

    }
    static MainActivity Instance()
    {
        return  mainActivity;
    }

     public void Refresh()
     {
         ContentResolver contentResolver = getContentResolver();
         Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"),null,null,null,null);
        int indexBody  = smsInboxCursor.getColumnIndex("body");
         int indexAddress  = smsInboxCursor.getColumnIndex("address");
        if(indexBody<0 || !smsInboxCursor.moveToFirst())
        {
            return;
        }
        do{
            String str = "SMS from : "+ smsInboxCursor.getString(indexAddress)+"\n";
            str+= smsInboxCursor.getString(indexBody);
            arrayAdapter.add(str);

        }while (smsInboxCursor.moveToNext());
     }
     public void updateList  (final String smsMSG )
     {
         arrayAdapter.insert(smsMSG, 0);
         arrayAdapter.notifyDataSetChanged();
     }
 }