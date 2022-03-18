package com.dot.lab_2_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginButton(View view)
    {
        EditText editText = findViewById(R.id.cms);
        String s = editText.getText().toString();
        if(s.length()== 11)
        {
            if(s.split("-").length==3)
            {
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
            else
            Toast.makeText(this,"Please enter Valid CMS",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Please enter Valid CMS",Toast.LENGTH_LONG).show();
        }

    }
}