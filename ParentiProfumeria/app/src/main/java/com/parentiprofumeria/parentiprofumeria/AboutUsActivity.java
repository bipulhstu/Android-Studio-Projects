package com.parentiprofumeria.parentiprofumeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import static maes.tech.intentanim.CustomIntent.customType;

public class AboutUsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        imageView = (ImageView) findViewById(R.id.aboutUsImageViewid);
        textView = (TextView) findViewById(R.id.aboutUsTextViewid);
        textView.setText("L'arredamento, l'esposizione, la relazione col cliente appartengono alla profumeria\n" +
                "classica per eccellenza.\n" +
                "L'assortimento vasto e ricercato di profumi selettivi tradizionali ed artigianali permette di\n" +
                "spaziare tra marchi importanti della profumeria selettiva , come è possibile visionare nelle\n" +
                "nostre pagine informative.\n" +
                "Anche la scelta dell'accessorio rispetta ricercatezza e qualità proponendo Reminissance\n" +
                "come bigiotteria-gioiello da regalarsi e da regalare.\n" +
                "L'assortimento e la ricercatezza non sono le uniche note che contraddistinguono la\n" +
                "Profumeria Parenti.\n" +
                "Le fondamenta storiche sono nel rapporto sincero e aperto col cliente, dove il servizio e la\n" +
                "consulenza non lasciano spazio ad improvvisazioni.\n" +
                "L'esperienza trentennale nel settore, l'attenzione e la continua formazione professionale,\n" +
                "rendono la consulenza, tecnica, mirata ad ogni esigenza della pelle e del maquillage,\n" +
                "proponendo per il settore cosmetico marchi esclusivi e all'avanguardia nella ricerca\n" +
                "scientifica.\n" +
                "Sedute di un'ora in cabina estetica, omaggiate dall'assistenza delle case cosmetiche\n" +
                "trattate, per l'elenco delle quali rimandiamo alle nostre pagine, permettono di ampliare il\n" +
                "servizio e la consulenza, regalando piacevoli momenti di relax.\n" +
                "Maquillage personalizzati e scuola trucco individuale, garantiscono un'attenzione\n" +
                "particolare alla ricercatezza dell'immagine, non stereotipata, ma come integrazione alla\n" +
                "individualità ed alla personalità che contraddistingue ogni cliente.");
        //adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){

            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

}
