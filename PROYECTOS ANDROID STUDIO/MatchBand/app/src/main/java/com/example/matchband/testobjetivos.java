package com.example.matchband;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class testobjetivos extends AppCompatActivity {

    private LinearLayout llObjetivos;
    private Button btnComenzar;
    private TextView tvOmitir;
    private ImageButton btnAtras;

    private String objetivoSeleccionado = "";
    private String nombre, correo, contrasena;
    private ArrayList<String> instrumentos, generos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testobjetivos);

        nombre = getIntent().getStringExtra("nombre");
        correo = getIntent().getStringExtra("correo");
        contrasena = getIntent().getStringExtra("contrasena");
        instrumentos = getIntent().getStringArrayListExtra("instrumentos");
        generos = getIntent().getStringArrayListExtra("generos");

        llObjetivos = findViewById(R.id.llObjetivos);
        btnComenzar = findViewById(R.id.btnComenzar);
        tvOmitir = findViewById(R.id.tvOmitir);
        btnAtras = findViewById(R.id.btnAtras);

        crearOpcionesObjetivo();

        btnComenzar.setOnClickListener(v -> finalizarOnboarding());
        tvOmitir.setOnClickListener(v -> finalizarOnboarding());
        btnAtras.setOnClickListener(v -> finish());
    }

    private void crearOpcionesObjetivo() {
        // TODO: Crear las 3 opciones con iconos
    }

    private void finalizarOnboarding() {
        // TODO: Guardar todo en MongoDB

        Toast.makeText(this, "¡Perfil completado!", Toast.LENGTH_SHORT).show();

        // Ir al MainActivity
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}