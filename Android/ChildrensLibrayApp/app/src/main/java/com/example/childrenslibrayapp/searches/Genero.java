package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.childrenslibrayapp.Listado;
import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.DynamicArray;

public class Genero extends AppCompatActivity {

    Spinner spinner1;
    Button bt_genero;

    public static final String EXTRA_SEARCH_TYPE = "com.example.childrenslibrayapp.SEARCH_TYPE";

    SearchEngine search = new SearchEngine(this);
    String searchTerm;
    Search ge = new Search("", "Genero");

    Datos datos = Datos.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);

        final Intent listadoIntent = new Intent(this, Listado.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_SEARCH_TYPE,"Genero");

        listadoIntent.putExtras(extras);

        datos.setByAuthorArray(new DynamicArray<Book>());

        spinner1=(Spinner)findViewById(R.id.spinner);
        bt_genero = (Button)findViewById(R.id.bt_busgenero);

        String [] opciones = {"Comedia","Comic","Cuento", "Educacion","Fabula", "Ficcion", "Ilsutrado", "Romantico"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);
        bt_genero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                searchTerm = spinner1.getSelectedItem().toString();

                if(!searchTerm.isEmpty()){
                    ge.setTempSearch(searchTerm);
                    try {
                        search.arraySearchBy(ge);
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
