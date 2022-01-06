package com.dot.consumer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {



    public static final Uri CONTENT_URI = Uri.parse("content://"+"com.dot.myProvider"+"/emp");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadData(View view)
    {
        Cursor cr = getContentResolver().query(CONTENT_URI, null, null, null, "_id");
        StringBuilder builder = new StringBuilder();

        while(cr.moveToNext())
        {
            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            builder.append(id+ " " + s1+ " "+ s2+ "\n");
        }
//        Toast.makeText(this,builder.toString() ,Toast.LENGTH_LONG) .show();
        TextView textView  =  findViewById(R.id.textView);
        textView.setText(builder.toString());

    }
}