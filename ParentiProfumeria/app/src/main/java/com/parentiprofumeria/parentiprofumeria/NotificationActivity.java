package com.parentiprofumeria.parentiprofumeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.realm.Realm;
import io.realm.RealmChangeListener;

import static maes.tech.intentanim.CustomIntent.customType;

public class NotificationActivity extends AppCompatActivity {
    private static String TAG = NotificationActivity.class.getSimpleName();
    private Realm realm;
    private RealmHelper helper;
    private RealmChangeListener realmChangeListener;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerView.Adapter<NotificationsAdapter.ViewHolder> adapter;
    private DividerItemDecoration mDividerItemDecoration;
    private ImageView noNotifications;
    FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_delete_button);


        noNotifications = (ImageView) findViewById(R.id.noNotifications);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNotifications);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(mDividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }

        //SETTING UP REALM

        realm = Realm.getDefaultInstance();

        helper = new RealmHelper(realm);

        helper.retrieveNotifications();

        checkNoNotifications();


        adapter = new NotificationsAdapter(NotificationActivity.this, helper.refreshNotifications());
        recyclerView.setAdapter(adapter);

        realmChangeListener = new RealmChangeListener() {
            @Override
            public void onChange(Object element) {

                checkNoNotifications();
                adapter = new NotificationsAdapter(NotificationActivity.this, helper.refreshNotifications());
                recyclerView.setAdapter(adapter);
            }
        };

        realm.addChangeListener(realmChangeListener);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationActivity.this, "All notification cleaned successfully!", Toast.LENGTH_SHORT).show();
                clearNotifications();
            }
        });

    }



    public void clearNotifications() {

        checkNoNotifications();
        RealmHelper helper = new RealmHelper(realm);
        helper.clearNotifications();
    }

    private void checkNoNotifications() {
        if (!helper.hasNotifications()) {
            noNotifications.setVisibility(View.VISIBLE);
        } else {
            noNotifications.setVisibility(View.GONE);
        }

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
