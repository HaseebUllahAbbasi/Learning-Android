package com.dot.lab_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "Tag";
    int[] rand_numbers =  new int[16];
    ImageButton[] imageButtons;
    Drawable[] drawables = new Drawable[8];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generate_numbers();
        getImages();
        generate_pic();
    }
    private  void getImages ()
    {
        drawables[0] = getResources().getDrawable(R.drawable.avengers);
        drawables[1] = getResources().getDrawable(R.drawable.groot);
        drawables[2] = getResources().getDrawable(R.drawable.hammer);
        drawables[3] = getResources().getDrawable(R.drawable.iron);
        drawables[4] = getResources().getDrawable(R.drawable.shield);
        drawables[5] = getResources().getDrawable(R.drawable.loki3);
        drawables[6] = getResources().getDrawable(R.drawable.loki_1);
        drawables[7] = getResources().getDrawable(R.drawable.tesseract);
    }


    private void generate_numbers()
    {

        int index = 0;
        int max = 9;
        int min = 1;
        Random random = new Random();
        boolean completed = false;
        while (!completed)
        {
            if(index==16)
                completed = true;
            int number =  random.nextInt(max - min) + min;
            if(checkNumber(number))
            {
                rand_numbers[index++] = number;
            }

        }

    }
    public void clickMethod(View view)
    {

    }

    @SuppressLint("ResourceType")
    public void generate_pic()
    {
        int counter = 0;
        imageButtons = new ImageButton[]{findViewById(R.id.imageButton),findViewById(R.id.imageButton2), findViewById(R.id.imageButton3), findViewById(R.id.imageButton4), findViewById(R.id.imageButton5), findViewById(R.id.imageButton6), findViewById(R.id.imageButton7), findViewById(R.id.imageButton8), findViewById(R.id.imageButton9), findViewById(R.id.imageButton10), findViewById(R.id.imageButton11), findViewById(R.id.imageButton12), findViewById(R.id.imageButton13), findViewById(R.id.imageButton14), findViewById(R.id.imageButton15), findViewById(R.id.imageButton16)};
        for(ImageButton btn: imageButtons)
        {

            btn.setImageDrawable(drawables[rand_numbers[counter] -1 ]);
            Log.d(TAG, "generate_pic: "+drawables[rand_numbers[counter] -1 ].toString() );
            counter++;
        }
    }

    private boolean checkNumber(int number)
    {
        int counter = 0 ;
        for(int num:rand_numbers)
        {
            if(number==num)
            counter++;
        }
        return counter <2;
    }
    public void resetGame(View view)
    {
        for(ImageButton btn: imageButtons)
        {


//             getResources().getDrawable(R.drawable);

//            btn.setImageDrawable();
//            Log.d(TAG, "generate_pic: "+drawables[rand_numbers[counter] -1 ].toString() );
//            counter++;
        }

        TextView textView = (findViewById(R.id.msg));
            textView.setText("reset is done ");
//        generate_numbers();
//        getImages();
//        generate_pic();
        textView.setText("reset is done  successfully");

    }
}