package com.example.mediaplayerdemo;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton playButton, pauseButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playButton = (ImageButton) findViewById(R.id.playButtonId);
        pauseButton = (ImageButton) findViewById(R.id.pauseButtonId);

        mediaPlayer = MediaPlayer.create(this, R.raw.nadaan);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.playButtonId){
            if(mediaPlayer != null){
                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "Song Played", Toast.LENGTH_SHORT).show();
            }

        }

        if(v.getId() == R.id.pauseButtonId){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "Song Paused", Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
