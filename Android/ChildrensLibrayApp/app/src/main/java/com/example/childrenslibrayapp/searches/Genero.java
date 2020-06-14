package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.childrenslibrayapp.R;

public class Genero extends AppCompatActivity {

    Spinner spinner1;
    Button bt_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero);

        spinner1=(Spinner)findViewById(R.id.spinner);
        bt_genero = (Button)findViewById(R.id.bt_busgenero);

        String [] opciones = {"Comedia","Comic","Cuento", "Educacion","Fabula", "Ficcion", "Ilsutrado", "Romantico"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);
        bt_genero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!spinner1.getSelectedItem().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
