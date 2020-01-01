package com.bipul.example.splashui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpAct extends AppCompatActivity {
    Animation fromButton, fromtop;
    Button joinButton;
    TextView signUp;
    EditText email, completeName, userName, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fromButton = AnimationUtils.loadAnimation(this,R.anim.frombutton);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);

        joinButton = (Button) findViewById(R.id.joinButtonId);
        signUp = (TextView) findViewById(R.id.signUp);
        email = (EditText) findViewById(R.id.emailEditTextId);
        completeName = (EditText) findViewById(R.id.completeNameId);
        userName = (EditText) findViewById(R.id.userNameId);
        country = (EditText) findViewById(R.id.countryLocationId);

        joinButton.startAnimation(fromButton);
        signUp.startAnimation(fromtop);
        email.startAnimation(fromtop);
        completeName.startAnimation(fromtop);
        userName.startAnimation(fromtop);
        country.startAnimation(fromtop);
    }
}
