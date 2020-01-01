package com.bipul.example.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static maes.tech.intentanim.CustomIntent.customType;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void OpenSignInPage(View view) {
        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
        customType(SignUpActivity.this, "right-to-left");
        finish();
    }
}
