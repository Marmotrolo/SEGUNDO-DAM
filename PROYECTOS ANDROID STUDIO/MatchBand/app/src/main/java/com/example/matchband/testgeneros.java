package com.example.matchband;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class testgeneros extends AppCompatActivity {

    private LinearLayout llGeneros;
    private Button btnSiguiente;
    private TextView tvOmitir;
    private ImageButton btnAtras;

    private ArrayList<String> generosSeleccionados = new ArrayList<>();
    private String nombre, correo, contrasena;
    private ArrayList<String> instrumentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testgeneros);

        nombre = getIntent().getStringExtra("nombre");
        correo = getIntent().getStringExtra("correo");
        contrasena = getIntent().getStringExtra("contrasena");
        instrumentos = getIntent().getStringArrayListExtra("instrumentos");

        llGeneros = findViewById(R.id.llGeneros);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        tvOmitir = findViewById(R.id.tvOmitir);
        btnAtras = findViewById(R.id.btnAtras);

        crearOpcionesGeneros();

        btnSiguiente.setOnClickListener(v -> irSiguiente());
        tvOmitir.setOnClickListener(v -> irSiguiente());
        btnAtras.setOnClickListener(v -> finish());
    }

    private void crearOpcionesGeneros() {
        String[] generos = {"Rock", "Metal", "Jazz", "Pop", "Indie", "Electrónica"};
        // TODO: Crear opciones dinámicamente
    }

    private void irSiguiente() {
        Intent intent = new Intent(this, testobjetivos.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("correo", correo);
        intent.putExtra("contrasena", contrasena);
        intent.putStringArrayListExtra("instrumentos", instrumentos);
        intent.putStringArrayListExtra("generos", generosSeleccionados);
        startActivity(intent);
    }
}