package com.bipulhstu.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button checkButton;
    private TextView resultTextVeiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextId);
        checkButton = (Button) findViewById(R.id.checkButtonId);
        resultTextVeiw = (TextView) findViewById(R.id.resultTextViewId);

        checkButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String guessString = editText.getText().toString();

        if(guessString.isEmpty()){

            errorMessage();
        }
        else{
            int guess = Integer.parseInt(guessString);

            if(guess > 5){
                errorMessage();
            }

            //Generating random number
            Random random = new Random();
            int randomNumber = random.nextInt(5)+1;

            if(randomNumber == guess){
                resultTextVeiw.setText("Congrats!!!! You have won");
            }
            else{
                resultTextVeiw.setText("Sorry! You have lost. Random number was: "+randomNumber);
            }
        }



    }
    void errorMessage(){
        editText.setError("Please enter a valid integer");
        editText.requestFocus();
        return;
    }
}
