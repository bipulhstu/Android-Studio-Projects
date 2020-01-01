package com.bipul.example.sqlitedatabasesignupsignin;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, emailEditText, usernameEditText, passwordEditText;
    private Button signUpButton;
    //UserDetails userDetails;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        emailEditText = (EditText) findViewById(R.id.emailEditTextId);
        usernameEditText = (EditText) findViewById(R.id.usernameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);
        signUpButton = (Button) findViewById(R.id.signUpButtonId);

        databaseHelper = new DatabaseHelper(this);
        //SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();

        //userDetails = new UserDetails();
        signUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try{
            String name = (String) nameEditText.getText().toString();
            String email = (String)emailEditText.getText().toString();
            String username =(String) usernameEditText.getText().toString();
            String password = (String)passwordEditText.getText().toString();
            UserDetails userDetails = new UserDetails();


            userDetails.setName(name);
            userDetails.setEmail(email);
            userDetails.setUsername(username);
            userDetails.setPassword(password);
            if(v.getId() == R.id.signUpButtonId){
                if(name.equals("") && email.equals("") && username.equals("") && password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter all the data", Toast.LENGTH_SHORT).show();
                }
                else {
                    long rowId = databaseHelper.insertData(userDetails);

                    if(rowId > 0){
                        Toast.makeText(getApplicationContext(), "Row "+rowId+"is successfully inserted", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Row insertion failed", Toast.LENGTH_LONG).show();
                    }
                }
            }



        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Exception : "+e, Toast.LENGTH_LONG).show();
        }


    }
}
