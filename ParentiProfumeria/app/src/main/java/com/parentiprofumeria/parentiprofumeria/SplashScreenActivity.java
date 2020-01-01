package com.parentiprofumeria.parentiprofumeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {
    ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startActivity();

            }
        });
        thread.start();
    }
    public void doWork(){
        for(progress = 20; progress<=100; progress=progress+20){
            try{
                Thread.sleep(400);
                progressBar.setProgress(progress);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    public void startActivity(){
        startActivity(new Intent(SplashScreenActivity.this, IntroSliderActivity.class));
        finish();

    }
}
