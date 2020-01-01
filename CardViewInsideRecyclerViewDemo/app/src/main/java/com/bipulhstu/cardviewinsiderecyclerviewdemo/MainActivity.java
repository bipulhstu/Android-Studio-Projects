package com.bipulhstu.cardviewinsiderecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.au, R.drawable.bd, R.drawable.bh, R.drawable.ca,
            R.drawable.ch, R.drawable.de, R.drawable.gb, R.drawable.fi,
            R.drawable.gh, R.drawable.in, R.drawable.jp, R.drawable.pk};

    String[] title, description;
    MyAdapter myAdapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);

        //find title and description from strings.xml
        title = getResources().getStringArray(R.array.country_names);
        description = getResources().getStringArray(R.array.country_description);
        //now pass data to adapter


        //send data
        myAdapter = new MyAdapter(getApplicationContext(), title, description, images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
