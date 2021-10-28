package com.dot.lab_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MSG" ;
    int[] images = {
        R.drawable.avengers,
            R.drawable.loki3,
            R.drawable.loki_1,
            R.drawable.groot,
            R.drawable.hammer,
            R.drawable.iron,
            R.drawable.shield,
            R.drawable.tesseract
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public int[] change_method()
    {
        Random random = new Random();
        for (int i=0; i<images.length; i++)
        {
            int indexToSwap = random.nextInt(images.length);
            int temp_var = images[indexToSwap];
            images[indexToSwap] = images[i];
            images[i] = temp_var;
        }
        return images;
    }
    ArrayList<ImageButton> compare = new ArrayList<>(2);
    ArrayList<Integer> compareSources = new ArrayList<Integer>(2);

    public void changePic (View view)
    {
        ImageButton imageButton = (ImageButton) view;

        Log.d(TAG, "changePic: "+imageButton.getTag().toString());
        int tag = Integer.parseInt(imageButton.getTag().toString());
        compare.add(imageButton);
        compareSources.add(images[tag]);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(compare.size()>1 && compareSources.size()<=2)
                {
                    if(images[tag]==compareSources.get(0))
                    {
                        imageButton.setClickable(false);
                        compare.get(0).setClickable(false);
                    }
                    else {
                        imageButton.setImageResource(R.drawable.defimg);
                        compare.get(0).setImageResource(R.drawable.defimg);
                    }
                    compare.clear();
                    compareSources.clear();

                }

            }
        },500);


    }

}