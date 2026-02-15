package com.example.matchband;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class crearcuenta extends AppCompatActivity {

    private EditText etNombreUsuario, etCorreo, etContrasena, etConfirmarContrasena;
    private Button btnCrearCuenta;
    private TextView tvIrLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearcuenta);

        // Referencias
        etNombreUsuario = findViewById(R.id.etNombreUsuario);
        etCorreo = findViewById(R.id.etCorreoRegistro);
        etContrasena = findViewById(R.id.etContrasenaRegistro);
        etConfirmarContrasena = findViewById(R.id.etConfirmarContrasena);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        tvIrLogin = findViewById(R.id.tvIrLogin);

        // Botón Crear Cuenta
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarRegistro();
            }
        });

        // Ir a Login
        tvIrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Vuelve al Login
            }
        });
    }

    private void validarRegistro() {
        String nombre = etNombreUsuario.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();
        String confirmarContrasena = etConfirmarContrasena.getText().toString().trim();

        // Validaciones
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Correo electrónico no válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (contrasena.length() < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: Guardar usuario en MongoDB




        // Por ahora, pasamos al onboarding

        Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();

        // Ir al onboarding (cuestionario)
        Intent intent = new Intent(crearcuenta.this, testinstrumentos.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("correo", correo);
        intent.putExtra("contrasena", contrasena);
        startActivity(intent);
        finish();
    }
}