package com.dot.dot_db_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dot.dot_db_android.data.DataBaseHelper;
import com.dot.dot_db_android.model.Contact;
import com.dot.dot_db_android.util.Util;

public class deleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }

    public void delete(View view)
    {
        EditText viewById = (EditText) findViewById(R.id.deleteTextField);
        String s = viewById.getText().toString();
        if(s.length()!=0)
        {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this, Util.DATABASE_NAME,null,Util.DATABASE_VERSION);
            Contact contact = dataBaseHelper.getContact(Integer.parseInt(s));
            int i = dataBaseHelper.deleteContact(contact);
            if(i==0)
                Toast.makeText(this,"Not Deleted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"Deleted The Data ",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Please Enter the text in the field ",Toast.LENGTH_LONG).show();
        }

    }
}