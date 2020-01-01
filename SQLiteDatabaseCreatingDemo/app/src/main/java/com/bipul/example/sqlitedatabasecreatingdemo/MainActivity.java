package com.bipul.example.sqlitedatabasecreatingdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyDatabaseHelper myDatabaseHelper;
    private EditText nameEditText, ageEditText, genderEditText, idEditText;
    private Button addbutton, displayButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  myDatabaseHelper.getWritableDatabase();

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        ageEditText = (EditText) findViewById(R.id.ageEditTextId);
        genderEditText = (EditText) findViewById(R.id.genderEditTextId);
        idEditText = (EditText) findViewById(R.id.idEditTextId);
        addbutton = (Button) findViewById(R.id.addButtonId);
        displayButton = (Button) findViewById(R.id.showAllDataButtonId);
        updateButton = (Button) findViewById(R.id.updateDataButtonId);
        deleteButton = (Button) findViewById(R.id.deleteDataButtonId);


        addbutton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //get data from edit text
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        String id = idEditText.getText().toString();


        if(v.getId() == R.id.addButtonId){

            //call
            long rowId = myDatabaseHelper.insertData(name, age, gender);
            if(rowId > 0){
                Toast.makeText(getApplicationContext(), "Row "+rowId+" successfully inserted!",Toast.LENGTH_LONG).show();
            }
            else if(rowId == -1){
                Toast.makeText(getApplicationContext(), "Not successfully inserted!",Toast.LENGTH_LONG).show();
            }
        }

        if(v.getId() == R.id.showAllDataButtonId){

           Cursor cursor = myDatabaseHelper.displayAllData();

           if(cursor.getCount() == 0){
               //Toast.makeText(getApplicationContext(), "There is no data", Toast.LENGTH_SHORT).show();
               showData("Error", "No data found");
               return;

           }
           StringBuffer stringBuffer = new StringBuffer();
           while (cursor.moveToNext()){
               stringBuffer.append("Id: "+cursor.getString(0)+"\n");
               stringBuffer.append("Name: "+cursor.getString(1)+"\n");
               stringBuffer.append("Age: "+cursor.getString(2)+"\n");
               stringBuffer.append("Gender: "+cursor.getString(3)+"\n\n");

           }

           showData("ResultSet", stringBuffer.toString());

        }
        if(v.getId() == R.id.updateDataButtonId){

              boolean isUpadated = myDatabaseHelper.updateData(name, age, gender, id);
              if(isUpadated == true){
                  Toast.makeText(getApplicationContext(), "Successfully updated", Toast.LENGTH_SHORT).show();

              }
              else{
                  Toast.makeText(getApplicationContext(), "Not updated", Toast.LENGTH_SHORT).show();
              }


        }
        if(v.getId() == R.id.deleteDataButtonId){

            int value = myDatabaseHelper.deleteData(id);

            if(value > 0){
                Toast.makeText(getApplicationContext(), "Data is deleted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Data is not deleted", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void showData(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();

    }
}
