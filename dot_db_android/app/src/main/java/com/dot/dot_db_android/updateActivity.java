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

public class updateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void updateData(View view) {

        EditText editText =  findViewById(R.id.updateId);
        EditText phone =  findViewById(R.id.updatePhone);
        EditText name =  findViewById(R.id.updateName);

        String s = editText.getText().toString();
        if(s.length()!=0)
        {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this, Util.DATABASE_NAME,null,Util.DATABASE_VERSION);
            Contact contact = dataBaseHelper.getContact(Integer.parseInt(s));
            contact.setPhone(phone.getText().toString());
            contact.setName(name.getText().toString());

            int i = dataBaseHelper.updateContact(contact);
            if(i==0)
                Toast.makeText(this,"Not Updated",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"Updated The Data ",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Please Enter the text in the field ",Toast.LENGTH_LONG).show();
        }

    }
}