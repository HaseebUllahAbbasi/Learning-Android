package com.dot.class5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        TextView textView = findViewById(R.id.editTextTextPersonName);
        String name  = textView.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("data",name);
        startActivity(intent);
        finish();
    }
}