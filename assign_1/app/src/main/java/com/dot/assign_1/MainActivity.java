package com.dot.assign_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void load_Game(View view)
    {
        Intent intent = new Intent(this,GameScreen.class);
        startActivity(intent);
        finish();
    }
    public void load_howToPlay(View view)
    {
        Intent intent = new Intent(this,HowToPlay.class);
        startActivity(intent);
        finish();
    }
}