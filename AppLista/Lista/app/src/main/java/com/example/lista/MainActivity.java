package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFoto;
    private RecyclerViewAdaptador adaptadorFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFoto=(RecyclerView)findViewById(R.id.recycler_imagen);
        recyclerViewFoto.setLayoutManager(new LinearLayoutManager(this));

        adaptadorFoto=new RecyclerViewAdaptador(obtenerFoto());
        recyclerViewFoto.setAdapter(adaptadorFoto);
    }

    public List<actividad_elegible> obtenerFoto(){
        List<actividad_elegible> foto=new ArrayList<>();
        foto.add(new actividad_elegible("Deportes", "CYT lunes por la tarde",R.drawable.crear));
        foto.add(new actividad_elegible("Arte", "CYT lunes por la mañna",R.drawable.crear));
        foto.add(new actividad_elegible("Conferencias", "CYT lunes por la tarde",R.drawable.crear));
        foto.add(new actividad_elegible("Otros", "lunes por la tarde",R.drawable.crear));
        foto.add(new actividad_elegible("Deportes", "CYT lunes por la mañama",R.drawable.crear));
        foto.add(new actividad_elegible("Deportes", "CYT lunes por la noche",R.drawable.crear));
        foto.add(new actividad_elegible("Deportes", "CYT lunes por la tarde",R.drawable.crear));

        return foto;
    }
}
