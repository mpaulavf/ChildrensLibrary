package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.childrenslibrayapp.Listado;
import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.DynamicArray;

public class Titulo extends AppCompatActivity {
    public static final String EXTRA_SEARCH_TYPE = "com.example.childrenslibrayapp.SEARCH_TYPE";

    SearchEngine search = new SearchEngine(this);
    String searchTerm;
    EditText txt;
    Search ti = new Search("", "Titulo");

    Datos datos = Datos.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulo);

        final Intent listadoIntent = new Intent(this, Listado.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_SEARCH_TYPE,"Titulo");

        listadoIntent.putExtras(extras);

        datos.setByTitleArray(new DynamicArray<Book>());

        txt = (EditText) findViewById(R.id.et_bustit);



        Button btn = (Button) findViewById(R.id.bt_bustit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTerm = txt.getText().toString();
                if(!searchTerm.isEmpty()){
                    ti.setTempSearch(searchTerm);

                    try {
                        search.arraySearchBy(ti);
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


//                    Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su busqueda", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

