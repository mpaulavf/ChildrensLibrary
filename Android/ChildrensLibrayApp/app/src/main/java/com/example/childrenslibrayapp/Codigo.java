package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.childrenslibrayapp.mockdata.SearchEngine;

public class Codigo extends AppCompatActivity {

    SearchEngine search;
    Button bt_cod;
    EditText codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);

        bt_cod = (Button)findViewById(R.id.bt_buscod);
        codigo = (EditText)findViewById(R.id.et_buscod);


        bt_cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!codigo.getText().toString().isEmpty()){
                    search.searchBy(,null)
                    Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
