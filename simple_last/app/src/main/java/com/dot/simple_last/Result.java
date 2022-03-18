package com.dot.simple_last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent =  getIntent();
        String right = intent.getStringExtra("right");
        String wrong = intent.getStringExtra("wrong");
        TextView textView =  findViewById(R.id.textView2);
            textView.setText("right : "+right + " Wrong "+ wrong);


    }

}