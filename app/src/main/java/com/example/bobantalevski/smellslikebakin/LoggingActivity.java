package com.example.bobantalevski.smellslikebakin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Boban Talevski on 10/4/2017.
 */

public class LoggingActivity extends AppCompatActivity {
    public static final String TAG = LoggingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate - pre");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate - post");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart - pre");
        super.onStart();
        Log.d(TAG, "onStart - post");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume - pre");
        super.onResume();
        Log.d(TAG, "onResume - post");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause - pre");
        super.onPause();
        Log.d(TAG, "onPause - post");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop - pre");
        super.onStop();
        Log.d(TAG, "onStop - post");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy - pre");
        super.onDestroy();
        Log.d(TAG, "onDestroy - post");
    }
}
