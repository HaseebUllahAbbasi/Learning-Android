package com.dot.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.turtles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                ImageView imageView = findViewById(R.id.imageView2);
                TextView textView = findViewById(R.id.textView);

                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                if (spinner.getSelectedItemPosition() == 0) {
                    imageView.setImageResource(R.drawable.loki_1);
                }
                else if (spinner.getSelectedItemPosition() == 1) {
                    imageView.setImageResource(R.drawable.t_1);
                }
                else if (spinner.getSelectedItemPosition() == 2) {
                    imageView.setImageResource(R.drawable.t_1);
                }
                else if (spinner.getSelectedItemPosition() == 2) {
                    imageView.setImageResource(R.drawable.t_1);
                }
                textView.setText(spinner.getSelectedItem().toString());




            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


    }


}