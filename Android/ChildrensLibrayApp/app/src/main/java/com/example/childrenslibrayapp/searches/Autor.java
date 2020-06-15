package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

public class Autor extends AppCompatActivity {
    public static final String EXTRA_SEARCH_TYPE = "com.example.childrenslibrayapp.SEARCH_TYPE";

    SearchEngine search = new SearchEngine(this);
    String searchTerm;
    EditText txt;
    Search au = new Search("", "Autor");

    Datos datos = Datos.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);

        final Intent listadoIntent = new Intent(this, Listado.class);
        //listadoIntent.setData(Uri.parse("Autor"));
        Bundle extras = new Bundle();
        extras.putString(EXTRA_SEARCH_TYPE,"Autor");

        listadoIntent.putExtras(extras);

        datos.setByAuthorArray(new DynamicArray<Book>());

        txt = (EditText) findViewById(R.id.et_busaut);



        Button btn = (Button) findViewById(R.id.bt_busaut);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTerm = txt.getText().toString();
                if(!searchTerm.isEmpty()){
                    au.setTempSearch(searchTerm); // Generando Null pointer que crashea el app
                    //Toast.makeText(getApplicationContext(), searchTerm, Toast.LENGTH_SHORT).show();
                    try {
                        search.arraySearchBy(au);
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su busqueda", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
