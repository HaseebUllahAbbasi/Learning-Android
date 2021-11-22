package com.dot.dot_db_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dot.dot_db_android.data.DataBaseHelper;
import com.dot.dot_db_android.model.Contact;
import com.dot.dot_db_android.util.Util;

public class InsertionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_screen);
        DataBaseHelper dataBaseHelper ;
    }

    public void insertData(View view) {
        EditText name = (EditText) findViewById(R.id.insertName);
        EditText phone = (EditText) findViewById(R.id.insertPass);
        String nameString = name.getText().toString();
        String phoneString = phone.getText().toString();

        if(nameString.equals("") && phoneString.equals(""))
        {
            Toast.makeText(this, "Please Enter the Full Data", Toast.LENGTH_SHORT).show();
            return;
        }
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
        int i = dataBaseHelper.addContact(new Contact(nameString,phoneString ));
        if (i == 0)
            Toast.makeText(this, "Data Not Inserted ", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data Inserted ", Toast.LENGTH_SHORT).show();

    }
}