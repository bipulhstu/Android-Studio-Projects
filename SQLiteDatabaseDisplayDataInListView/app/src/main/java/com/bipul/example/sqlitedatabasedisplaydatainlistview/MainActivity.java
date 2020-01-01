package com.bipul.example.sqlitedatabasedisplaydatainlistview;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseHelper databaseHelper;
    private EditText idEditText, nameEditText;
    private Button saveButton, showButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        idEditText = (EditText) findViewById(R.id.idEditTextId);
        saveButton = (Button) findViewById(R.id.saveButtonId);
        showButton = (Button) findViewById(R.id.showButtonId);
        updateButton = (Button) findViewById(R.id.updateButtonId);
        deleteButton = (Button) findViewById(R.id.deleteButtonId);


        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();

        if(v.getId() == R.id.saveButtonId){

            if(id.equals("") && name.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter all the data", Toast.LENGTH_SHORT).show();
            }
            else{


                long rowNumber = databaseHelper.saveData(id, name);
                if(rowNumber > -1){
                    Toast.makeText(getApplicationContext(), "Data is inserted successfully", Toast.LENGTH_SHORT).show();
                    idEditText.setText("");
                    nameEditText.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Data is not inserted successfully", Toast.LENGTH_SHORT).show();
                }
            }


        }
        if(v.getId() == R.id.showButtonId){


            Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.updateButtonId){

            Boolean isUpdated = databaseHelper.updateData(id, name);

            if(isUpdated == true){
                Toast.makeText(getApplicationContext(), "Data is updated", Toast.LENGTH_SHORT).show();
                idEditText.setText("");
                nameEditText.setText("");
            }
            else{
                Toast.makeText(getApplicationContext(), "Data is not updated", Toast.LENGTH_SHORT).show();
            }


        }
        if(v.getId() == R.id.deleteButtonId){

            int value = databaseHelper.deleteData(id);
            if(value < 0){
                Toast.makeText(getApplicationContext(), "Data is not deleted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Data is deleted", Toast.LENGTH_SHORT).show();
                idEditText.setText("");
                nameEditText.setText("");
            }

        }

    }
}
