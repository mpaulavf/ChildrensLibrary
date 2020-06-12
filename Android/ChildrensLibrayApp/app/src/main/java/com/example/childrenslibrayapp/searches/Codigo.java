package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.mockdata.SearchEngine;
import com.example.childrenslibrayapp.objects.Search;

//genera un crash al presionar buscar

public class Codigo extends AppCompatActivity {

    SearchEngine search = new SearchEngine(this);
    Button bt_cod;
    EditText codigo;
    Search dc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);

        bt_cod = (Button)findViewById(R.id.bt_buscod);
        codigo = (EditText)findViewById(R.id.et_buscod);


        bt_cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = codigo.getText().toString();
                if(!cod.isEmpty()){
                    dc.setTempSearch(cod);
                    Toast.makeText(getApplicationContext(), cod, Toast.LENGTH_SHORT).show();
                    dc.setCategory("Codigo");
                    try {
                        search.searchBy(dc);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
