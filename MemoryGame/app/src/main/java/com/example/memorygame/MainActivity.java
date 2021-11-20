package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    int[] array = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
    };
    ArrayList<ImageButton> compare= new ArrayList<>(2);
    ArrayList<Integer> compareImageSource= new ArrayList<>(2);


    private int[] shuffle(){

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

        return array;
    }



    public void changeFace(View view){
        ImageButton imgButton = (ImageButton) view;
        int tag = Integer.parseInt(imgButton.getTag().toString());
        compare.add(imgButton);
        compareImageSource.add(array[tag]);
        imgButton.setImageResource(array[tag]);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 5 seconds
                if(compare.size()>1&&compare.size()<=2){
                    if(array[tag]==compareImageSource.get(0)){
                        imgButton.setClickable(false);
                        compare.get(0).setClickable(false);

                    }else{
                        imgButton.setImageResource(R.drawable.what);
                        compare.get(0).setImageResource(R.drawable.what);
                    }
                    compare.clear();
                    compareImageSource.clear();
                }

            }
        }, 500);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shuffle();

    }
}