package com.parentiprofumeria.parentiprofumeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static maes.tech.intentanim.CustomIntent.customType;

public class ContactUsActivity extends AppCompatActivity {
    TextView facebookTextView, instagramTextView, storeAddressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        facebookTextView = (TextView) findViewById(R.id.facebookTextViewid);
        instagramTextView = (TextView) findViewById(R.id.instagramTextViewid);
        storeAddressTextView = (TextView) findViewById(R.id.addressTextViewid);

        facebookTextView.setMovementMethod(LinkMovementMethod.getInstance());
        instagramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        storeAddressTextView.setMovementMethod(LinkMovementMethod.getInstance());

        //adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){

            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
