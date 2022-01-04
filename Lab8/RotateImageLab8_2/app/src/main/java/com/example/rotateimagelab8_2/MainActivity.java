package com.example.rotateimagelab8_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    private boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img  = findViewById(R.id.imageView);
    }

    boolean isRotationOn = false;
    public void rotate()
    {

        Thread thread = new Thread(new Runnable() {
            int i=0;

            @Override
            public void run() {

                while (true) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img.setRotation(i);
                        }
                    });
                    if (isRotationOn)
                            i++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        if(!isRunning) {
            thread.start();
            isRunning=true;
        }
    }

   public void onToggle(View view) {

        rotate();
        isRotationOn=!isRotationOn;
    }

}