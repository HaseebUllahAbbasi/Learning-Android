package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] images;
    ImageView[] imgview;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new int[]{R.drawable.bee,R.drawable.bird,R.drawable.bird_1,R.drawable.flower,R.drawable.helicopter,R.drawable.tulip,R.drawable.bee,R.drawable.bird,R.drawable.bird_1,R.drawable.flower,R.drawable.helicopter,R.drawable.tulip};
        imgview = new ImageView[]{findViewById(R.id.imageView),findViewById(R.id.imageView2),findViewById(R.id.imageView3),findViewById(R.id.imageView4),findViewById(R.id.imageView5),findViewById(R.id.imageView6),findViewById(R.id.imageView7),findViewById(R.id.imageView8),findViewById(R.id.imageView9),findViewById(R.id.imageView13),findViewById(R.id.imageView14),findViewById(R.id.imageView15)};
        txt = findViewById(R.id.textview);
        Random rand = new Random();

        for (int i = 0; i < images.length; i++) {
            int randomIndexToSwap = rand.nextInt(images.length);
            int temp = images[randomIndexToSwap];
            images[randomIndexToSwap] = images[i];
            images[i] = temp;
        }
    }
    int id[] = new int[2];
    int tg[] =  new int[2];
    int count = 0;
    public void ShowImg(View view)
    {

        ImageView img = (ImageView) view;
        int tag = Integer.parseInt(img.getTag().toString());
        id[count]= images[tag];
        tg[count] = tag;
        count++;
        img.setEnabled(false);
        img.setImageResource(images[tag]);
        if(id[0] == id[1])
        {
            txt.setText("Congratulations!. You won the game.");
            disableAll();
            id[0]=0;
            id[1]=0;
        }
        else if(id[0] != id[1] && count == 2)
        {
            for (ImageView iv:imgview) {
                iv.setEnabled(false);
            }
            runthread();
        }

    }
    public void disableAll()
    {
        for (ImageView view:imgview
             ) {
            view.setEnabled(false);
        }

    }
    private void runthread() {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imgview[tg[0]].setImageResource(R.drawable.question);
                        imgview[tg[1]].setImageResource(R.drawable.question);
                        count = 0;
                        imgview[tg[0]].setEnabled(true);
                        imgview[tg[1]].setEnabled(true);
                        id[0]=0;
                        id[1]=0;
                        for (ImageView view:imgview
                        ) {
                            view.setEnabled(true);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}