package com.dot.arslanpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_screen);
    }

    public void InsertData(View view)
    {
        EditText name = (EditText)findViewById(R.id.insertname);
        EditText phone = (EditText)findViewById(R.id.insertnumber);

        String nameString = name.getText().toString();
        String phoneString = phone.getText().toString();

        if(nameString.equals("") && phoneString.equals(""))
        {
            Toast.makeText(this,"Please Enter Full Data",Toast.LENGTH_LONG).show();
            return;
        }
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this,Util.DATABASE_NAME,null,Util.DATABASE_VERSION);
        int i = dataBaseHelper.AddContact(new Contact(nameString,phoneString));
        if(i==0)
        {
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this,"Data Inserted Done",Toast.LENGTH_LONG).show();

        }

    }


}