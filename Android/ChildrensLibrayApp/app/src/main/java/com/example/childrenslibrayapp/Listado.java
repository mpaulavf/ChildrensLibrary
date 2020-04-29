package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    private RecyclerView recyclerViewlibro;
    private RecyclerViewAdaptador adaptadorlibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recyclerViewlibro= (RecyclerView) findViewById(R.id.recView_listadoLibros);
        recyclerViewlibro.setLayoutManager(new LinearLayoutManager(this));

        adaptadorlibro = new RecyclerViewAdaptador(obtenerlibro());
        recyclerViewlibro.setAdapter(adaptadorlibro);

    }

    public List<LibroEnLista> obtenerlibro(){
        List<LibroEnLista> libro= new ArrayList<>();
        libro.add(new LibroEnLista("Un monstru viene a verme", "Patrick Ness","Accion", "0958458",R.drawable.libro1));
        libro.add(new LibroEnLista("El principito", "Antoine de Saint-Exupéry","Accion", "0958457",R.drawable.libro2));
        libro.add(new LibroEnLista("El maravilloso mago de Oz", "L. Frank Baum","Accion", "0958456",R.drawable.libro3));
        libro.add(new LibroEnLista("Las aventuras de Pinocho", "Carlo Collodi","Accion", "0958455",R.drawable.libro4));
        libro.add(new LibroEnLista("Apestoso tío Muffin", "Pedro Mañas","Accion", "0958454",R.drawable.libro5));

        return libro;

    }
}
