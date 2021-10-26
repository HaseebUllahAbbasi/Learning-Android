package com.dot.lab_4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nexus(View view)
    {
        TextView textView =  findViewById(R.id.textView);
        ImageView imageView =  findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.lokisylvie));
        textView.setText("Loki is Happy with Sylvie");
    }
}