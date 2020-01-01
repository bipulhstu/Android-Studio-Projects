package com.bipul.example.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView normalTextView, boldTextView;
    private Button button;
    Animation atg, btgone, btgtwo;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boldTextView = (TextView) findViewById(R.id.boldTextViewId);
        normalTextView = (TextView) findViewById(R.id.normalTextViewId);
        button = (Button) findViewById(R.id.buttonTextViewId);
        imageView = (ImageView) findViewById(R.id.imageViewId);

        //load animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        //passing event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StopWatchAct.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        //passing animation
        imageView.startAnimation(atg);
        boldTextView.startAnimation(btgone);
        normalTextView.startAnimation(btgtwo);
        imageView.startAnimation(btgtwo);


        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        //customize fonts
        boldTextView.setTypeface(MRegular);
        normalTextView.setTypeface(MLight);
        button.setTypeface(MMedium);
    }
}
