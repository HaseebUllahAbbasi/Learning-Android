package com.dot.arslanpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class Records extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        getAllData();

    }

    public void getAllData()
    {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, Util.DATABASE_NAME,null,Util.DATABASE_VERSION);
        List<Contact> allContacts = dataBaseHelper.getAllContacts();
        Log.d(TAG, "getAllData: "+ " got the data");
        LinearLayout linearLayout  =   findViewById(R.id.linear_1);
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