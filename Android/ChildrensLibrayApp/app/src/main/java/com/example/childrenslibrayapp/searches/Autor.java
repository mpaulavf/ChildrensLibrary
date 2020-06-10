package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.childrenslibrayapp.R;

public class Autor extends AppCompatActivity {
    String searchTerm;
    EditText txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);


        txt = (EditText) findViewById(R.id.et_busaut);

        searchTerm = txt.getText().toString();

        Button btn = (Button) findViewById(R.id.bt_busaut);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
