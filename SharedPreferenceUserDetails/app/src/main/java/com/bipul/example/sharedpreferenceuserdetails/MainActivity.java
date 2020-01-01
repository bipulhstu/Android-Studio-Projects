package com.bipul.example.sharedpreferenceuserdetails;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView detailsTextView;
    private EditText userNameEditText, passwordEditText;
    private Button saveButton, loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailsTextView = (TextView) findViewById(R.id.detailsTextViewId);
        userNameEditText = (EditText) findViewById(R.id.userNameId);
        passwordEditText = (EditText) findViewById(R.id.passwordId);
        saveButton = (Button) findViewById(R.id.saveButtonId);
        loadButton = (Button) findViewById(R.id.loadButtonId);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.saveButtonId){

            ///get string from edittext
            String username = userNameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if(username.equals("") && password.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();
            }
            else{
                ///save string using shared preference
                SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
                ///write data using edit methoo
                SharedPreferences.Editor editor = sharedPreferences.edit();
                ///put data
                editor.putString("usernameKey", username);
                editor.putString("passwordKey", password);

                ///commit
                editor.commit();
                //to make edit Text clean
                userNameEditText.setText("");
                passwordEditText.setText("");
                Toast.makeText(getApplicationContext(), "Data is stored successfully", Toast.LENGTH_SHORT).show();
            }


        }

        else if(v.getId() == R.id.loadButtonId){

            ///to read data
            SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

            if(sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey")){
                String username = sharedPreferences.getString("usernameKey", "Data not found");
                String password = sharedPreferences.getString("passwordKey", "Data not found");

                detailsTextView.setText(username+"\n"+password);

            }
        }

    }

}
