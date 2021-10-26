package com.dot.lab_4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer quantity = 0;
    private static final String TAG = "MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.number_qty);
        textView.setText(quantity.toString());

    }

    public void calculate_bill(View view)
    {
        CheckBox chocolate =  findViewById(R.id.chocolate);
        CheckBox cream =  findViewById(R.id.cream);
        if(cream.isChecked())
            Log.d(TAG, "Cream is Checked: ");
        if(chocolate.isChecked())
            Log.d(TAG, "chocolate is Checked: ");
        Log.d(TAG, "calculate_bill: "+ quantity );
    }

    public void Add(View view)
    {

        if(quantity<=10)
        {
            quantity++;
        }
        TextView textView = findViewById(R.id.number_qty);
        textView.setText(quantity.toString());
        Log.d(TAG, "Add: ");
    }

    public void Sub(View view)
    {
        if(quantity>=0)
        {
            quantity--;


        }
        TextView textView = findViewById(R.id.number_qty);
        textView.setText(quantity.toString());
        Log.d(TAG, "Sub: ");
    }
}