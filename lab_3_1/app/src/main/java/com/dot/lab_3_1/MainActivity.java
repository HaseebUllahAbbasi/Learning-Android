package com.dot.lab_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Integer number;
    Integer count = 0;

    Integer min = 1;
    Integer max = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        number =  random.nextInt(max - min) + min;
    }

    public void ResetNewNumber(View view)
    {

        Random random = new Random();
        number =  random.nextInt(max - min) + min;
        TextView message = findViewById(R.id.HighLowTextView);
        EditText numberComp = findViewById(R.id.NumberEntered );
        message.setText("Waiting For Number");
        numberComp.setText("");

    }

    public void checkEnteredNumber(View view)
    {
        count++;
        TextView message = findViewById(R.id.HighLowTextView);
        TextView tries =  findViewById(R.id.triesTextView);
        EditText numberComp = findViewById(R.id.NumberEntered );
        Long enteredNumber =  Long.parseLong(numberComp.getText().toString());
        if(enteredNumber>number)
        {
            message.setText("Enter Nunmber is Greater");
        }
        else if(enteredNumber<number)
        {
            message.setText("Enter Nunmber is Less");
        }
        else
        {
            message.setText("Matched");
        }
        tries.setText("Tries "+ count+ " Times");
    }
}