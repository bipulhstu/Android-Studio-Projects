package com.bipul.example.activityanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Default(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    public void lefttoright(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        customType(MainActivity.this, "left-to-right");
    }

    public void righttoleft(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        customType(MainActivity.this, "right-to-left");
    }

    public void bottomtoup(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        customType(MainActivity.this, "bottom-to-up");
    }

    public void uptobottom(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        customType(MainActivity.this, "up-to-bottom");
    }
    public void fadeintofadeout(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        customType(MainActivity.this, "fadein-to-fadeout");
    }

    public void rotateouttorotatein(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        customType(MainActivity.this, "rotateout-to-rotatein");
    }



}
