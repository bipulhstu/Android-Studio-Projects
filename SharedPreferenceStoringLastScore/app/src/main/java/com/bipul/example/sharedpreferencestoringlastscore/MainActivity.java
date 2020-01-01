package com.bipul.example.sharedpreferencestoringlastscore;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView scoretextView;
    private Button increaseButton, decreaseButton;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoretextView = (TextView) findViewById(R.id.textViewId);
        increaseButton = (Button) findViewById(R.id.increaseScoreId);
        decreaseButton = (Button) findViewById(R.id.decreaseScoreId);

        ///load last score
        if(loadScore() != 0){
            scoretextView.setText("Score: "+loadScore());
        }

        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.increaseScoreId){
            score = score + 10;
            scoretextView.setText("Score: "+score);

            //save increased score using SharedPreference
            saveScore(score);
        }

        else if(v.getId() == R.id.decreaseScoreId){
            score = score - 10;
            scoretextView.setText("Score: "+score);

            //save increased score using SharedPreference
            saveScore(score);
        }
    }
    private void saveScore(int score){
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);
        editor.commit();
    }

    //load previous score
    private int loadScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        int lastScore = sharedPreferences.getInt("lastScore", 0);

        return lastScore;
    }
}
