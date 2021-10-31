package com.example.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void rules(View view)
    {
        Intent intent = new Intent(this,howToPlay.class);
        startActivity(intent);

    }

    public void play(View view)
    {
        Intent intent = new Intent(this,mainGame.class);
        startActivity(intent);

    }
}