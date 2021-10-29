package com.dot.lab_4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer num_1;
    private static final String TAG = "MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void number_method(View view) {
        Button button = (Button) view;
        int i = Integer.parseInt((String) button.getText());
        TextView textView = findViewById(R.id.textView2);
        textView.setText("" + textView.getText() + i);
        Log.d(TAG, "" + textView.getText() + i);
    }

    public void clear(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText("");
    }

    String operator = "";

    public void operation(View view) {
        TextView textView = findViewById(R.id.textView2);
        Button button = (Button) view;
        num_1 = Integer.parseInt((String) textView.getText());
        textView.setText("");
        operator = (String) button.getText();
    }

    Integer num_2;

    public void equalButton(View view) throws Exception {
        TextView textView = findViewById(R.id.textView2);
        num_2 = Integer.parseInt((String) textView.getText());
        if(operator.equals("+"))
        {
            Integer res =  (num_1+num_2);
            textView.setText(res.toString());
        }
        else if(operator.equals("-"))
        {
                Integer res =  (num_1-num_2);
                textView.setText(res.toString());
        }
        else if(operator.equals("*"))
        {
            Integer res =  (num_1*num_2);
            textView.setText(res.toString());
        }
        else if(operator.equals("/"))
        {
            if(num_2==0)
            {
                throw  new Exception("Not Divisible By Zero");
            }
            Integer res =  (num_1-num_2);
            textView.setText(res.toString());
        }
        else if(operator.equals("%"))
        {

            if(num_2==0)
            {
                throw  new Exception("Not Divisible By Zero");
            }
            Integer res =  (num_1%num_2);
            textView.setText(res.toString());
        }



    }
}