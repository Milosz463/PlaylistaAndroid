package com.example.pracanalekcji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textViewTytul;
    TextView textViewinfo;
    TextView textViewPolubienia;
    ImageButton buttonWstecz;
    ImageButton buttonDalej;
    Button buttonPobierz;
    int aktualnaPiesn;
    int pobrania;

ArrayList<Album>albumy=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        textViewTytul=findViewById(R.id.textView2);
        textViewinfo=findViewById(R.id.textView3);
        buttonWstecz=findViewById(R.id.imageButton);
        buttonDalej=findViewById(R.id.imageButton2);
        buttonPobierz=findViewById(R.id.button3);
        textViewPolubienia=findViewById(R.id.textView6);

        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnaPiesn--;
                        if(aktualnaPiesn<0){
                            aktualnaPiesn=albumy.size()-1;
                        }
                        dodajPiesn(aktualnaPiesn);
                    }
                }
        );

        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnaPiesn++;
                        if(aktualnaPiesn==albumy.size()){
                            aktualnaPiesn=0;
                        }
                        dodajPiesn(aktualnaPiesn);
                    }
                }

        );

        buttonPobierz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pobierz(aktualnaPiesn);
                    }
                }
        );

        aktualnaPiesn=0;


        albumy.add(new Album("Gorillaz","The Now Now",11,2018,11000102));
        albumy.add(new Album("My Chemical Romance","The Black Parade", 14, 2006, 304666444));
        albumy.add(new Album("Wilki", "wilki", 16, 1992, 4000230));
        albumy.add(new Album("30 Seconds To Mars", "A Beautiful Lie", 13, 2009, 300120222));
        albumy.add(new Album("30 Seconds To Mars", "This Is War", 15, 2009, 22000000));
        dodajPiesn(aktualnaPiesn);
    }
    public void dodajPiesn(int i){
        Album album=albumy.get(i);
        textView.setText(album.getWykonawca());
        textViewTytul.setText(album.getTytul());
        textViewinfo.setText(String.valueOf(album.getRocznik())+" "+String.valueOf(album.getUtwory()));
        textViewPolubienia.setText(String.valueOf(album.getPobrania()));
    }
    public void pobierz(int j){
        Album album=albumy.get(j);
        album.zwiekszPobrania();
        textViewPolubienia.setText(String.valueOf(album.getPobrania()));
    }
}