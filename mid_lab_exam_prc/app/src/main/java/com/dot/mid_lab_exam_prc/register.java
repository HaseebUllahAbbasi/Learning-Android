package com.dot.mid_lab_exam_prc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void register(View view)
    {

        EditText Remail = findViewById(R.id.registerEmail);
        EditText Rpassword = findViewById(R.id.registerPassword);

        SharedPreferences preferences = getSharedPreferences("task_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("email",Remail.getText().toString());
        edit.putString("pass",Rpassword.getText().toString());
        edit.apply();
        Toast.makeText(this,"MSG:"+Remail.getText().toString() ,Toast.LENGTH_LONG).show();




    }

    public void  backLog(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}