package com.dot.lab_7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddUser extends AppCompatActivity {

    public static List<User> list = new ArrayList<User>();
    EditText name,email,phone;
    DbHelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextPersonName2);
        phone = findViewById(R.id.editTextTextPersonName3);
        dBhelper = new DbHelper(this);
    }
    public void addUser(View view)
    {
        if(name.getText().toString().equals("") || email.getText().toString().equals("") || phone.getText().toString().equals(""))
        {
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else {
            dBhelper.insertData(name.getText().toString(), email.getText().toString(), phone.getText().toString());
            Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
        }

    }
    public void onShow(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}