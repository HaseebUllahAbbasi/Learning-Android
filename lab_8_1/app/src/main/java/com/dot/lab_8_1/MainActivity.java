package com.dot.lab_8_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int seconds;
    private Integer mSec = 0;
    private Integer Sec = 0;
    private Integer Min = 0;
    boolean running  = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        runTimer();
    }

    public void EndService(View view)
    {
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        stopService(serviceIntent);
        running = false;
    }

    public void startService(View view) {
        Intent serviceIntent = new Intent(this,ForegroundService.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android ");
        ContextCompat.startForegroundService(this,serviceIntent);
        running = true;
    }
    private void runTimer()
    {

        // Get the text view.
        final TextView timeView
                = (TextView)findViewById(
                R.id.textView);

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {


                // Format the seconds into hours, actualSeconds,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", Min,
                                seconds,mSec );

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
//                    seconds++;

                    mSec++;

                    if((mSec%100)==0)
                    {
                        seconds++;
                        mSec=0;
                    }
                    if(seconds==60)
                    {
                        Min++;
                        seconds = 0;
                    }
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1);
            }
        });
    }
}