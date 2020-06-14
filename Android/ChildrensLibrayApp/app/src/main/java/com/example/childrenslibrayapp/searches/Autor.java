package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.objects.Search;

public class Autor extends AppCompatActivity {
    SearchEngine search = new SearchEngine(this);
    String searchTerm;
    EditText txt;
    Search au = new Search("", "Autor");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);


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
