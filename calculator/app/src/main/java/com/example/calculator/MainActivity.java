package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void add(View view)
    {
        TextView lbl = findViewById(R.id.textView2);
        EditText txt1 = findViewById(R.id.editTextNumber);
        EditText txt2 = findViewById(R.id.editTextNumber2);
        Integer num1 = Integer.parseInt(txt1.getText().toString());
        Integer num2 = Integer.parseInt(txt2.getText().toString());
        lbl.setText((num1+num2)+" ");

    }
    public void subtract(View view)
    {

    }
    public void multiply(View view)
    {

    }
    public void division(View view)
    {

    }
}