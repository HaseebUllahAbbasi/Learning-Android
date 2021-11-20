package com.dot.dot_db_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dot.dot_db_android.data.DataBaseHelper;
import com.dot.dot_db_android.model.Contact;
import com.dot.dot_db_android.util.Util;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ViewAll extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        getAllData();
    }
    public void getAllData()
    {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, Util.DATABASE_NAME,null,Util.DATABASE_VERSION);
        List<Contact> allContacts = dataBaseHelper.getAllContacts();
        Log.d(TAG, "getAllData: "+ " got the data");
        LinearLayout linearLayout  =   findViewById(R.id.viewAll);
        for (Contact contact :allContacts)
        {
            TextView textView = new TextView(this);
            textView.setText(contact.toString());
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(textView);

//            Log.d(TAG, "getAllData: "+ contact.toString());
        }

    }

}