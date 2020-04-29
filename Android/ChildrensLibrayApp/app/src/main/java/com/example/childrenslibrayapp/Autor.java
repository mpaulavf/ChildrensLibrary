package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Autor extends AppCompatActivity {
    String searchTerm;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);


        txt = (EditText) findViewById(R.id.txt_authorSearch);

        searchTerm = txt.getText().toString();

        Button btn = (Button) findViewById(R.id.btn_authorSearch);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
