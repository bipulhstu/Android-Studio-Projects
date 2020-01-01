/*
What is Fragment?
    *A fragment is a kind of sub activity.
    *Can have several fragments in an activity.
    *Can add or remove fragments in an activity whuile the activity is runnuing
    *Fragment has its own lifecycle.
    *A fragement can be used in multiple acitivities.
 */


package com.bipulhstu.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    String name[] = {"Bipul", "Dinonath" , "Sorwar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Fragment fragment;
        if(i==0){
            //object of fragment
            fragment = new BipulFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId, fragment);
            fragmentTransaction.commit();
        }
        else if(i==1){
            //object of fragment
            fragment = new DinoFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId, fragment);
            fragmentTransaction.commit();
        }
        else if(i==2){
            //object of fragment
            fragment = new SorwarFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId, fragment);
            fragmentTransaction.commit();
        }
    }
}
