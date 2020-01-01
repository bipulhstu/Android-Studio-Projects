package com.bipul.example.sqlitedisplayalldata;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, ageEditText, genderEditText;
    private Button addButton, displayButton;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        ageEditText =  (EditText)findViewById(R.id.ageEditTextId);
        genderEditText = (EditText) findViewById(R.id.genderEditTextId);
        addButton = (Button) findViewById(R.id.addButtonId);
        displayButton = (Button) findViewById(R.id.showButtonId);

        addButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if(v.getId() == R.id.addButtonId){
            long rowId = myDatabaseHelper.insertData(name, age, gender);
            if(rowId == -1){
                Toast.makeText(getApplicationContext(), "Unsuccessfull", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Row "+rowId+ " is inserted successfully", Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId() == R.id.showButtonId){

        }

    }

}
