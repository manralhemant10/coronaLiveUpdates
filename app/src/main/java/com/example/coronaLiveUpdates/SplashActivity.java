package com.example.coronaLiveUpdates;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 2000;
    private TextView skip ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_launch);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(homeintent);
                finish();

            }

        },SPLASH_TIME_OUT);
    }
}
