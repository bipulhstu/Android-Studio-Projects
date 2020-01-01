package com.bipulhstu.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button callButton, webButton, locationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callButton = (Button) findViewById(R.id.telButtonId);
        webButton = (Button) findViewById(R.id.webButtonId);
        locationButton = (Button) findViewById(R.id.mapButtonId);

        callButton.setOnClickListener(this);
        webButton.setOnClickListener(this);
        locationButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.telButtonId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+8801777833756"));
            startActivity(intent);
        }
        else if(v.getId() == R.id.webButtonId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bipulhstu.github.io/me/"));
            startActivity(intent);
        }
        else if(v.getId() == R.id.mapButtonId){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 24.896837, 91.902739"));
            startActivity(intent);
        }
    }
}
