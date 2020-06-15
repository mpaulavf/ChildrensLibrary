package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.mockdata.ObjectReader;
import com.example.childrenslibrayapp.objects.*;
import com.example.childrenslibrayapp.searches.Autor;
import com.example.childrenslibrayapp.structures.*;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    private static final String TAG = "ListadoActivity";
    private RecyclerView recyclerViewlibro;
    private RecyclerViewAdaptador adaptadorlibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Datos datos = Datos.getInstance();

        String searchType = "";

        //Uri searchTypeUri = intent.getData();

        if(getIntent().hasExtra(Autor.EXTRA_SEARCH_TYPE)) {
            searchType = getIntent().getStringExtra(Autor.EXTRA_SEARCH_TYPE);
            Log.d(TAG, "onCreate: " + searchType);
        }

        DynamicArray <Book> listaLibros = datos.getAllBooksArray();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recyclerViewlibro= (RecyclerView) findViewById(R.id.recView_listadoLibros);
        recyclerViewlibro.setLayoutManager(new LinearLayoutManager(this));

        switch (searchType){
            case "Autor":
                listaLibros = datos.getByAuthorArray();
                break;
            case "Titulo":
                listaLibros = datos.getByTitleArray();
                break;
            case "Genero":
                listaLibros = datos.getByGenreArray();
                break;
            case "Codigo":
                listaLibros = datos.getByCodeArray();
                break;
            default:
                break;

        }
        adaptadorlibro = new RecyclerViewAdaptador(listaLibros);
        //adaptadorlibro = new RecyclerViewAdaptador(obtenerlibro());

        //adaptadorlibro = new RecyclerViewAdaptador(obtenerlibro()); //acá deberíamos obtener un dynamic array de los resultados de busqueda y pasarlo como parámetro del RecyclerView
        // Hace falta también inicializar el listado de libros de manera global en alguna otra parte del app
        // Una vez hecho esto ya es cuestión de que funcionela búsqueda retornando un DynamicArray con los resultados y listo
        // para tener a la mano los resultados de busqueda habría que exportarlos a un archivo csv como resultados
        // DEBE haber algo más fácil, jaja :c
        recyclerViewlibro.setAdapter(adaptadorlibro);

    }

    /*@Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();


    }*/

}
