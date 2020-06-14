package com.example.childrenslibrayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText TextEmailReg;
    private EditText TextPaswordReg;
    private EditText TextNombre;
    private EditText TextApellido;
    private EditText TextCEmail;
    private EditText TextCPass;
    private Button btRegistrarReg;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        TextEmailReg = (EditText) findViewById(R.id.et_correo);
        TextPaswordReg = (EditText) findViewById(R.id.et_cont);
        TextNombre = (EditText) findViewById(R.id.et_nombre);
        TextApellido = (EditText) findViewById(R.id.et_apellidos);
        TextCEmail = (EditText) findViewById(R.id.et_confcorreo);
        TextCPass = (EditText) findViewById(R.id.et_confcont);
        btRegistrarReg = (Button) findViewById(R.id.but_registro);

        btRegistrarReg.setOnClickListener(this);
    }

    private void Registrar(){
        String nombre = TextNombre.getText().toString().trim();
        String apellido = TextApellido.getText().toString().trim();
        String email = TextEmailReg.getText().toString().trim();
        String password = TextPaswordReg.getText().toString().trim();
        String conf_email = TextCEmail.getText().toString();
        String conf_pass = TextCPass.getText().toString();

        if (TextUtils.isEmpty(nombre)){
            Toast.makeText(this, "Por favor ingrese un email",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(apellido)){
            Toast.makeText(this, "Por favor ingrese una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por favor ingrese una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Por favor ingrese una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(conf_email)){
            Toast.makeText(this, "Por favor ingrese una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(conf_pass)){
            Toast.makeText(this, "Por favor ingrese una contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Registro.this, "Se ha gusrdado el email",Toast.LENGTH_LONG).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(Registro.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Registro.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Registrar();
    }
}
