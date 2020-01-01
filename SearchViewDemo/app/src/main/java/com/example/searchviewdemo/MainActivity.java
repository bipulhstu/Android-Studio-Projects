package com.example.searchviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import javax.xml.transform.sax.SAXResult;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    ArrayAdapter<String> adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewId);
        searchView = (SearchView) findViewById(R.id.searchViewId);

        String[] countryNames = getResources().getStringArray(R.array.country_names);

        adapter = new ArrayAdapter<String>(this, R.layout.sample_view, R.id.textViewId, countryNames);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;

            }
        });





    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String value = adapter.getItem(position);
        Toast.makeText(MainActivity.this,value, Toast.LENGTH_SHORT).show();
    }
}
