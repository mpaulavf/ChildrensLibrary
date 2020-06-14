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
import com.example.childrenslibrayapp.objects.Search;

//genera un crash al presionar buscar

public class Codigo extends AppCompatActivity {

    SearchEngine search = new SearchEngine(this);
    Button bt_codExacto, bt_codRango;
    EditText codigoExacto, codigoRango1, codigoRango2;
    Search dc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);

        bt_codExacto = (Button)findViewById(R.id.bt_busCodExacto);
        bt_codRango = (Button)findViewById(R.id.bt_busCodRango);
        codigoExacto = (EditText)findViewById(R.id.et_busCodExacto);
        codigoRango1 = (EditText)findViewById(R.id.et_busCodRan1);
        codigoRango2 = (EditText)findViewById(R.id.et_busCodRan2);



        bt_codExacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = codigoExacto.getText().toString();
                dc = new Search(cod, "Codigo");
                if(!cod.isEmpty()){
                    //dc.setTempSearch(cod);
                    Toast.makeText(getApplicationContext(), cod, Toast.LENGTH_SHORT).show();
                    //dc.setCategory("Codigo");
                    try {
                        search.arraySearchBy(dc);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Codigo.this, Listado.class));//Falta modificar a que Listado cargue los resultados de la busqueda. Tania, aiuda que tu sabes de esto, jaja
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_codRango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ran1 = codigoRango1.getText().toString();
                String ran2 = codigoRango2.getText().toString();
                dc = new Search(ran1, "Codigo"); //volverRangeSearch
                if(!ran1.isEmpty()&&!ran2.isEmpty()){
                    //dc.setTempSearch(cod);
                    Toast.makeText(getApplicationContext(), "de" + ran1 + "a" + ran2, Toast.LENGTH_SHORT).show();
                    //dc.setCategory("Codigo");
                    try {
                        search.arraySearchBy(dc);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Codigo.this, Listado.class));//Falta modificar a que Listado cargue los resultados de la busqueda. Tania, aiuda que tu sabes de esto, jaja
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
