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

    public DynamicArray <Book> obtenerlibro(){
        DynamicArray<Book> libros = new DynamicArray<Book>();

        ObjectReader oR = new ObjectReader(this);

        oR.readBooks(libros);
        /*
        List<LibroEnLista> libro= new ArrayList<>();
        libro.add(new LibroEnLista("Un monstruo viene a verme", "Patrick Ness","Accion", "0958458",R.drawable.libro1));
        libro.add(new LibroEnLista("El principito", "Antoine de Saint-Exupéry","Accion", "0958457",R.drawable.libro2));
        libro.add(new LibroEnLista("El maravilloso mago de Oz", "L. Frank Baum","Accion", "0958456",R.drawable.libro3));
        libro.add(new LibroEnLista("Las aventuras de Pinocho", "Carlo Collodi","Accion", "0958455",R.drawable.libro4));
        libro.add(new LibroEnLista("Apestoso tío Muffin", "Pedro Mañas","Accion", "0958454",R.drawable.libro5));
        */

        return libros;

    }
}
