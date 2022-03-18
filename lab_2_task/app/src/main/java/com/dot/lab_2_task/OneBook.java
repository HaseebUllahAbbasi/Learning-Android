package com.dot.lab_2_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OneBook extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_book);
        Intent intent = getIntent();
        int img = intent.getIntExtra("img",0);
        String author = intent.getStringExtra("author");
        String title = intent.getStringExtra("title");
        String issue = intent.getStringExtra("issue");
        String issuedTo = intent.getStringExtra("issuedTo");
        String avail = intent.getStringExtra("avail");

        ImageView imageView = findViewById(R.id.imageView);
        TextView author_view = findViewById(R.id.authorView);
        TextView title_view = findViewById(R.id.title_view);
        TextView issue_view = findViewById(R.id.issue_book);
        TextView issue_to_view = findViewById(R.id.issued_to);
        TextView avail_view = findViewById(R.id.avail_book);

        avail_view.setText(avail);

        imageView.setImageResource(img);



    }
}