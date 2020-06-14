package com.example.childrenslibrayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class IngresoTrab extends AppCompatActivity implements View.OnClickListener {

    private EditText TextEmailTrab;
    private EditText TextPaswordTrab;
    private EditText TextCodigo;
    private Button btIngresarTrab;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_trab);

        mAuth = FirebaseAuth.getInstance();

        TextEmailTrab = (EditText) findViewById(R.id.et_emailTrab);
        TextPaswordTrab = (EditText) findViewById(R.id.et_PasswordTrab);
        TextCodigo = (EditText) findViewById(R.id.et_codigo);
        btIngresarTrab = (Button) findViewById(R.id.bnIngresarTrab);

        btIngresarTrab.setOnClickListener(this);
    }
    private void IngresarTrab() {
        String email = TextEmailTrab.getText().toString().trim();
        String password = TextPaswordTrab.getText().toString().trim();
        String codigo = TextCodigo.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por favor ingrese un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Por favor ingrese una contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(codigo)) {
            Toast.makeText(this, "Por favor ingrese el codigo", Toast.LENGTH_LONG).show();
            return;
        }
        if (codigo.equals("bibliotrab")) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), Trabajador.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(IngresoTrab.this, "No se ha encontrado el usuario", Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });

        } else{
            Toast.makeText(IngresoTrab.this, "Codigo incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        IngresarTrab();
    }
}
