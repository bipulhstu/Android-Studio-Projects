package com.bipul.example.stopwatch;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {
    Button buttonStart;
    ImageView icanchor;
    Animation roundingalone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        icanchor = (ImageView) findViewById(R.id.iconImageViewId);

        //load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        //customize font
        buttonStart.setTypeface(MMedium);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
            }
        });


    }
}
