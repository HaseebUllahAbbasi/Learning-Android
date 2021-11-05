package com.dot.ratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Activity_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int img = intent.getIntExtra("img", 0);
        double rating = intent.getDoubleExtra("rating", 0.0);
        String details = intent.getStringExtra("details");

        ImageView imageView = findViewById(R.id.imageView);
        TextView data  = findViewById(R.id.textView5);
        RatingBar rating1 = findViewById(R.id.rating);
        imageView.setImageDrawable(getResources().getDrawable(img));
        rating1.setRating((float) rating);
        data.setText(details);

    }
}