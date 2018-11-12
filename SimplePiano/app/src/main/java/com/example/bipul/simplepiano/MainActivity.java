package com.example.bipul.simplepiano;

import android.media.AudioManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.SoundPool;


public class MainActivity extends AppCompatActivity {

    Button c, d, e, f, g, a, b, c1, d1, e1, chash, dhash, fhash, ghash, ahash, c1hash, d1hash;
    private SoundPool soundPool;
    private int sound_c, sound_d, sound_e, sound_f, sound_g, sound_a, sound_b, sound_c1, sound_d1, sound_e1, sound_chash, sound_dhash, sound_fhash, sound_ghash;
    private int sound_ahash, sound_c1hash, sound_d1hash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c1 = (Button) findViewById(R.id.c1);
        d1 = (Button) findViewById(R.id.d1);
        e1 = (Button) findViewById(R.id.e1);
        chash = (Button) findViewById(R.id.chash);
        dhash = (Button) findViewById(R.id.dhash);
        fhash= (Button) findViewById(R.id.fhash);
        ghash = (Button) findViewById(R.id.ghash);
        ahash = (Button) findViewById(R.id.ahash);
        c1hash = (Button) findViewById(R.id.c1hash);
        d1hash = (Button) findViewById(R.id.d1hash);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else
        {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_c = soundPool.load(this, R.raw.c, 1);
        sound_d = soundPool.load(this, R.raw.d, 1);
        sound_e = soundPool.load(this, R.raw.e, 1);
        sound_f = soundPool.load(this, R.raw.f, 1);
        sound_g = soundPool.load(this, R.raw.g, 1);
        sound_a = soundPool.load(this, R.raw.a, 1);
        sound_b = soundPool.load(this, R.raw.b, 1);

        sound_c1 = soundPool.load(this, R.raw.c1, 1);
        sound_d1 = soundPool.load(this, R.raw.d1, 1);
        sound_e1 = soundPool.load(this, R.raw.e1, 1);

        sound_chash = soundPool.load(this, R.raw.chash, 1);
        sound_dhash = soundPool.load(this, R.raw.dhash, 1);

        sound_fhash = soundPool.load(this, R.raw.fhash, 1);
        sound_ghash = soundPool.load(this, R.raw.ghash, 1);
        sound_ahash = soundPool.load(this, R.raw.ahash, 1);

        sound_c1hash = soundPool.load(this, R.raw.c1hash, 1);
        sound_d1hash = soundPool.load(this, R.raw.d1hash, 1);





        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c, 1, 1, 0, 0, 1);

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d, 1, 1, 0, 0, 1);

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e, 1, 1, 0, 0, 1);

            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f, 1, 1, 0, 0, 1);

            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_g, 1, 1, 0, 0, 1);

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_a, 1, 1, 0, 0, 1);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c1, 1, 1, 0, 0, 1);
            }
        });
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d1, 1, 1, 0, 0, 1);

            }
        });
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e1, 1, 1, 0, 0, 1);

            }
        });
        chash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_chash, 1, 1, 0, 0, 1);

            }
        });
        dhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_dhash, 1, 1, 0, 0, 1);

            }
        });
        fhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_fhash, 1, 1, 0, 0, 1);

            }
        });
        ghash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_ghash, 1, 1, 0, 0, 1);
            }
        });
        ahash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_ahash, 1, 1, 0, 0, 1);
            }
        });
        c1hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c1hash, 1, 1, 0, 0, 1);

            }
        });
        d1hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d1hash, 1, 1, 0, 0, 1);

            }
        });









    }
}
