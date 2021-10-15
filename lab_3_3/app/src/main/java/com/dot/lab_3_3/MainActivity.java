package com.dot.lab_3_3;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "12384789" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickedGlasses(View view)
    {
        CheckBox checkBoxHat =  findViewById(R.id.glassesBox);
        ImageView glasses = findViewById(R.id.glasses);
        if(checkBoxHat.isChecked())
        {
            glasses.setVisibility(View.VISIBLE);
        }
        else
        {
            glasses.setVisibility(View.INVISIBLE);
        }
    }

    public void clickedHat(View view)
    {
        CheckBox checkBoxHat =  findViewById(R.id.hatBox);
        ImageView hat_1 = findViewById(R.id.hat);
        if(checkBoxHat.isChecked())
        {
            hat_1.setVisibility(View.VISIBLE);
        }
        else
        {
            hat_1.setVisibility(View.INVISIBLE);
        }
    }

}