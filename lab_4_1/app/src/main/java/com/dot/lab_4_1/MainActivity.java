package com.dot.lab_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
// On start
/*
D/MSG: onCreate:
D/MSG: onStart:
D/MSG: onResume:
 */
// onLock
/*
D/MSG: onPause:
D/MSG: onStop:
 */

// onUnlock
/*
D/MSG: onRestart:
D/MSG: onStart:
D/MSG: onResume:
 */

//rotation
/*
D/MSG: onPause:
D/MSG: onStop:
D/MSG: onDestroy:
D/MSG: onCreate:
D/MSG: onStart:
D/MSG: onResume:
 */

// onEndingApp
/*
Destroy
D/MSG: onPause:
D/MSG: onStop:
D/MSG: onDestroy:
 */