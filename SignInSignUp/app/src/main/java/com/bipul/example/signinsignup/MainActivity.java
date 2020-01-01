package com.bipul.example.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.graphics.Color;
import android.content.Intent;
import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);


        setContentView(R.layout.activity_main);
    }

    public void OpenSignupPage(View view) {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
        customType(MainActivity.this, "left-to-right");
        finish();
    }
}
