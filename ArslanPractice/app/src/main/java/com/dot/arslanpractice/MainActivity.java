package com.dot.arslanpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void  GoToInsert(View view)
    {
        Intent intent = new Intent(this,InsertScreen.class);
        startActivity(intent);
    }

    public  void  Records(View view)
    {
        Intent intent = new Intent(this,Records.class);
        startActivity(intent);
    }
}