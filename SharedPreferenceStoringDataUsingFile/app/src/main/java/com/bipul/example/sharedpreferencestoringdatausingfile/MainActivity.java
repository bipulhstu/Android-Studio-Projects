package com.bipul.example.sharedpreferencestoringdatausingfile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button saveButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.saveButtonId);
        editText = (EditText) findViewById(R.id.editTextId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text != null){
                    writeToFile(text);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();
                }

            }
        });
        readFromFile();

    }

    ///write data to file
    public void writeToFile(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("diary.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data is saved successfully", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///read data from file
    public void readFromFile(){
        try {
            FileInputStream fileInputStream = openFileInput("diary.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stirngBuffer = new StringBuffer();

            while((line = bufferedReader.readLine()) != null){

                stirngBuffer.append(line +"\n");
            }
            editText.setText(stirngBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
