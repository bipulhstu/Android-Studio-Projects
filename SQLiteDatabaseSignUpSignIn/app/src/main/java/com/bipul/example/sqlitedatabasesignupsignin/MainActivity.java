package com.bipul.example.sqlitedatabasesignupsignin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditText, passwordEditText;
    private Button signInButton, signUpHereButton;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        usernameEditText = (EditText) findViewById(R.id.usernameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);
        signInButton = (Button) findViewById(R.id.signInButtonId);
        signUpHereButton = (Button) findViewById(R.id.signUpHereButtonId);

        signInButton.setOnClickListener(this);
        signUpHereButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId() == R.id.signInButtonId){

            Boolean result = databaseHelper.findPassword(username, password);

            if(result == true){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Username and password didn't match", Toast.LENGTH_SHORT).show();
            }
        }

        else if(v.getId() == R.id.signUpHereButtonId){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

    }
}
