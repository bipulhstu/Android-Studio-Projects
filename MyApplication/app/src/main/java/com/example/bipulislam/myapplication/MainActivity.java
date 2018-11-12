package com.example.bipulislam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.SharedPreferences.Editor;
import android.widget.TextView;
import android.view.View;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView textView;
    private Button loginButton, logoutButton;
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loginButtonId)
        {
            textView.setText("Login button is clicked");
        }
        if (v.getId()==R.id.logoutButtonId)
        {
            textView.setText("Logout button is clicked");
        }
    }
}
