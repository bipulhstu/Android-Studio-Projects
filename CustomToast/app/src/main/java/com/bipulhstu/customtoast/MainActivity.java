package com.bipulhstu.customtoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.buttonId);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //creating an instance of LayoutInflater
        LayoutInflater inflater = getLayoutInflater();

        //get the view object from the customtoast_layout
        View customView = inflater.inflate(R.layout.customtoast_layout, (ViewGroup) findViewById(R.id.customToastId));

        TextView textView = (TextView) findViewById(R.id.customToastTextId);

        //creating the toast object
        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(customView);
        toast.show();
    }
}
