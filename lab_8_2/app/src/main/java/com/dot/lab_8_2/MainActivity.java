package com.dot.lab_8_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Thread thread;
    Boolean toggle;
    Animation aniRotateClk;
    Button btn;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);
        toggle = true;
        aniRotateClk = AnimationUtils.loadAnimation (getApplicationContext (), R.anim.animation);
        btn= findViewById(R.id.button);

            runTimer();
    }

    public void btnRotate(View view)
    {
        toggle = !toggle;

    }
    private void runTimer()
    {


        final Handler handler
                = new Handler();

        handler.post(new Runnable() {
            @Override

            public void run()
            {

                if(toggle==true)
                    img.startAnimation(aniRotateClk);
                handler.postDelayed(this, 1000);
            }
        });
    }

}