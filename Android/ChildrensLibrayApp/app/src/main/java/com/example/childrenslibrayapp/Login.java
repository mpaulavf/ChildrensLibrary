package com.example.childrenslibrayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText TextEmail;
    private EditText TextPasword;
    private Button btIngresar;
    private TextView TextRegistrar, TextTrabajador;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        TextEmail = (EditText) findViewById(R.id.et_email);
        TextPasword = (EditText) findViewById(R.id.et_Pass);
        btIngresar = (Button) findViewById(R.id.bn_ingresar);
        TextRegistrar = (TextView) findViewById(R.id.tv_registrarse);
        TextTrabajador = (TextView) findViewById(R.id.tv_trabajador);

        TextRegistrar.setOnClickListener(this);
        btIngresar.setOnClickListener(this);
        TextTrabajador.setOnClickListener(this);
    }

    private void Registrar(){
        Intent registrar= new Intent(getApplicationContext(), Registro.class);
        startActivity(registrar);
    }

    private void Trabajador(){
        Intent trabajador= new Intent(getApplicationContext(), IngresoTrab.class);
        startActivity(trabajador);
    }

    private void Ingresar(){
        String email = TextEmail.getText().toString().trim();
        String password = TextPasword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por favor ingrese un email",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Por favor ingrese una contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "No se ha encontrado el usuario",Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_registrarse:
                Registrar();
                break;
            case R.id.bn_ingresar:
                Ingresar();
                break;
            case R.id.tv_trabajador:
                Trabajador();
                break;
        }

    }
}
