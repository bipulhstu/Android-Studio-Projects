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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signUpEmailEditText, signUpPasswordEditText;
    private TextView signInTextView;
    private Button signUpButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.setTitle("Sign Up Activity");
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signUpEmailEditText = (EditText) findViewById(R.id.emailSignUpEditTextId);
        signUpPasswordEditText = (EditText) findViewById(R.id.passwordSignUpEditTextId);
        signInTextView = (TextView) findViewById(R.id.signInTextViewId);
        signUpButton = (Button) findViewById(R.id.signUpButtonId);
        progressBar = (ProgressBar) findViewById(R.id.progressBarId);

        signUpButton.setOnClickListener(this);
        signInTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.signUpButtonId:
                userRegister();


                break;


            case R.id.signInTextViewId:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister() {
        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty()){
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        //checking the validity of the password
        if(password.isEmpty()){
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }

        if(password.length() < 6){

            signUpPasswordEditText.setError("Minimum length of a password should be 6");
            signUpPasswordEditText.requestFocus();
            return;
        }
        ///start the progress bar
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //stop the progress bar
                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    //finish sign in activity
                    finish();

                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Registration is successful", Toast.LENGTH_SHORT).show();

                } else {
                    //for duplicate email address
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }
}
