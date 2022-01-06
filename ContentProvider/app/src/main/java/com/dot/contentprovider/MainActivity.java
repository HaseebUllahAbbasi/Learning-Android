package com.dot.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    EditText name, job;
    ContentValues values = new ContentValues();
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.empName);
        job = findViewById(R.id.empJob);
        layout = findViewById(R.id.linearLayout);


    }

    public void save(View view) {
        values.put("emp_name",name.getText().toString());
        values.put("profile",job.getText().toString());
        Uri uri =  getContentResolver().insert(CustomProvider.CONTENT_URI,values);

        Toast.makeText(this,uri.toString(),Toast.LENGTH_LONG).show();


    }

    public void load(View view)
    {
        Cursor cr = getContentResolver().query(CustomProvider.CONTENT_URI, null, null, null, "_id");
        StringBuilder builder = new StringBuilder();

        while(cr.moveToNext())
        {
            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            builder.append(id+ " " + s1+ " "+ s2+ "\n");
        }
//        Toast.makeText(this,builder.toString() ,Toast.LENGTH_LONG) .show();
        Snackbar.make(layout,builder.toString(),Snackbar.LENGTH_LONG).show();
    }
}