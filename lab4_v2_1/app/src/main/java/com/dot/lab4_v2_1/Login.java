package com.dot.lab4_v2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {

        TextView email = findViewById(R.id.loginEmail);
        TextView password = findViewById(R.id.loginPass);

        SharedPreferences sPref = getSharedPreferences("fullName", Context.MODE_PRIVATE);
        String GotFName = sPref.getString("fullName", "No Name Defined");
        String GotEmail = sPref.getString("email", "No Email Defined");
        String GotPassword = sPref.getString("password", "No Password Defined");
        Log.d(TAG, "name :  " + GotFName + " Fname " + GotFName + " GotPassword " + GotPassword);

        if ((email.getText().toString().equals(GotEmail) && ((password.getText().toString().equals(GotPassword))))) {

            TextView status = findViewById(R.id.statusLogin);
            status.setText("Logged In Successfully");
        } else {
            TextView status = findViewById(R.id.statusLogin);
            status.setText("Not Logined");
        }

    }


    public void SignUp(View view) {

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();


    }

}