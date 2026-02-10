package com.example.fichajediario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private Button btnAcceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword =  findViewById(R.id.etPassword);
        btnAcceso =  findViewById(R.id.btnAcceso);

        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            //Dirige a una activity dependiendo del usuario y contraseña
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                if (usuario.equals("rrhh") && password.equals("rrhh")) {
                    Intent i = new Intent(Login.this, RRHH.class);
                    startActivity(i);
                } else if (usuario.equals("trabajador") && password.equals("trabajador")) {
                    Intent i = new Intent(Login.this, Trabajador.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Login.this, "Error: Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}