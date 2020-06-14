package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.childrenslibrayapp.Listado;
import com.example.childrenslibrayapp.R;

public class Busqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
    }
    public void Genero(View view) {
        Intent genero = new Intent(this, Genero.class);
        startActivity(genero);
    }


    public void Autor(View view) {
        Intent autor = new Intent(this, Autor.class);
        startActivity(autor);
    }


    public void Titulo(View view) {
        Intent titulo = new Intent(this, Titulo.class);
        startActivity(titulo);
    }

    public void Codigo(View view) {
        Intent codigo = new Intent(this, Codigo.class);
        startActivity(codigo);
    }
    public void Listado(View view) {
        Intent listado = new Intent(this, Listado.class);
        startActivity(listado);
    }

}
