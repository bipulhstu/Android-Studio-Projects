package com.example.feedbackmenudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.shareId){
            //Intent is used for go to one activity to another
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject  = "C Programming App";
            String body = "This app is very helpful.\n com.example.sharemenudemo";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Share with this app"));
        }
        else if(item.getItemId() == R.id.feedbackId){
            Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
