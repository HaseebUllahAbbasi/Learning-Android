package com.dot.lab_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void newGame(View view)
    {
        EditText user_1 =  findViewById(R.id.userName_1);
        EditText user_2 =  findViewById(R.id.userName_2);
        Intent intent = new Intent(this,MainActivity.class);
        
        intent.putExtra("user_1",user_1.getText().toString());
        intent.putExtra("user_2",user_2.getText().toString());
        startActivity(intent);


    }
}