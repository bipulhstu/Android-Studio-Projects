package com.bipul.example.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signInEmailEditText, signInPasswordEditText;
    private TextView signUpTextView;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In Activity");

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signInEmailEditText = (EditText) findViewById(R.id.emailSignInEditTextId);
        signInPasswordEditText = (EditText) findViewById(R.id.passwordSignInEditTextId);
        signUpTextView = (TextView) findViewById(R.id.signUpTextViewId);
        signInButton = (Button) findViewById(R.id.signInButtonId);
        progressBar = (ProgressBar) findViewById(R.id.progressBarId);



        signInButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.signInButtonId:

                userLogin();

                break;


            case R.id.signUpTextViewId:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;
    }

    }

    private void userLogin() {

        String email = signInEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty()){
            signInEmailEditText.setError("Enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            signInEmailEditText.setError("Enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }
        //checking the validity of the password
        if(password.isEmpty()){
            signInPasswordEditText.setError("Enter a password");
            signInPasswordEditText.requestFocus();
            return;
        }

        if(password.length() < 6){

            signInPasswordEditText.setError("Minimum length of a password should be 6");
            signInPasswordEditText.requestFocus();
            return;
        }
        ///start the progress bar
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //stop the progress bar
                progressBar.setVisibility(View.GONE);

                if(task.isSuccessful()){

                    //finish sign in activity
                    finish();

                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login unsuccessful", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
