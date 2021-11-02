package com.dot.lab4_v2_1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void register(View view) {

        TextView fullName = findViewById(R.id.fullNText);
        TextView email = findViewById(R.id.loginEmail);
        TextView password = findViewById(R.id.loginPass);

        SharedPreferences pref = getSharedPreferences("fullName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editable = pref.edit();

        editable.putString("fullName", fullName.getText().toString());
        editable.putString("email", email.getText().toString());
        editable.putString("password", password.getText().toString());
        editable.commit();

        TextView status = findViewById(R.id.statusSignUp);
        status.setText("Registered Successfully");

    }

    public void showLogin(View view) {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();


    }
}