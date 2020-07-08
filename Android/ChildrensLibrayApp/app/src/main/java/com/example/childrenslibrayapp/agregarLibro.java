package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class agregarLibro extends AppCompatActivity {

    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_libro);

        spinner2 =(Spinner)findViewById(R.id.spinner2);

        String [] opciones = {"Comedia","Comic","Cuento", "Educacion","Fabula", "Ficcion", "Ilustrado", "Romantico"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner2.setAdapter(adapter);
    }


}
