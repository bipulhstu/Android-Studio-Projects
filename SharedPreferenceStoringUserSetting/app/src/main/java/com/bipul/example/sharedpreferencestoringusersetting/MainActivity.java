package com.bipul.example.sharedpreferencestoringusersetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutId);

        ///load previous color
        if(loadColor() != getResources().getColor(R.color.colorPrimary)){
            linearLayout.setBackgroundColor(loadColor());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.redColorMenuItemId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
            storeColor(getResources().getColor(R.color.redColor));

        }
        if(item.getItemId() == R.id.greenColorMenuItemId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
            storeColor(getResources().getColor(R.color.greenColor));

        }
        if(item.getItemId() == R.id.yellowColorMenuItemId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
            storeColor(getResources().getColor(R.color.yellowColor));

        }
        if(item.getItemId() == R.id.pinkColorMenuItemId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.pinkColor));
            storeColor(getResources().getColor(R.color.pinkColor));

        }

        return super.onOptionsItemSelected(item);
    }
    private void storeColor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor", color);
        editor.commit();
    }

    ///load previous color
    private int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("myColor", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
