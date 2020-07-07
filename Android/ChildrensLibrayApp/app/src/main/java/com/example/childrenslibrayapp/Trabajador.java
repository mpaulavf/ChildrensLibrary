package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.childrenslibrayapp.searches.Autor;
import com.example.childrenslibrayapp.searches.Codigo;
import com.example.childrenslibrayapp.searches.Genero;
import com.example.childrenslibrayapp.searches.Titulo;
import com.example.childrenslibrayapp.workerCommands.agregarLibro;

public class Trabajador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador);

    }

    public void AgregarLibro(View view) {
        Intent agregarLibro = new Intent(this, agregarLibro.class);
        startActivity(agregarLibro);
    }

    public void QuitarLibro(View view) {
        Intent quitarLibro = new Intent(this, quitarLibro.class);
        startActivity(quitarLibro);
    }
    public void PrestarLibro(View view) {
        Intent prestarLibro = new Intent(this, prestarLibro.class);
        startActivity(prestarLibro);
    }
    public void DevolverLibro(View view) {
        Intent devolverLibro = new Intent(this, devolverLibro.class);
        startActivity(devolverLibro);
    }
    public void QuitarMora(View view) {
        Intent quitarMora = new Intent(this, quitarMora.class);
        startActivity(quitarMora);
    }





}
