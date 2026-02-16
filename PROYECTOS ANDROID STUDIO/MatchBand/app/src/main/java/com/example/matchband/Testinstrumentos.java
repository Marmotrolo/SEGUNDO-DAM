package com.example.matchband;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Testinstrumentos extends AppCompatActivity {

    private GridLayout gridInstrumentos;
    private Button btnSiguiente;
    private TextView tvOmitir;

    private ArrayList<String> instrumentosSeleccionados = new ArrayList<>();
    private String nombre, correo, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testinstrumentos);

        nombre = getIntent().getStringExtra("nombre");
        correo = getIntent().getStringExtra("correo");
        contrasena = getIntent().getStringExtra("contrasena");

        gridInstrumentos = findViewById(R.id.gridInstrumentos);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        tvOmitir = findViewById(R.id.tvOmitir);

        crearOpcionesInstrumentos();

        btnSiguiente.setOnClickListener(v -> irSiguiente());
        tvOmitir.setOnClickListener(v -> irSiguiente());
    }

    private void crearOpcionesInstrumentos() {
        String[] instrumentos = {"Guitarra", "Batería", "Voz", "Bajo", "Teclado", "Otros"};
        int[] iconos = {
                R.drawable.ic_guitar,
                R.drawable.ic_drums,
                R.drawable.ic_microphone,
                R.drawable.ic_bass,
                R.drawable.ic_music,
                R.drawable.ic_more
        };

        for (int i = 0; i < instrumentos.length; i++) {
            final String instrumento = instrumentos[i];
            final int icono = iconos[i];

            View card = getLayoutInflater().inflate(R.layout.item_opcion_instrumento, null);

            ImageView ivIcono = card.findViewById(R.id.ivIcono);
            TextView tvNombre = card.findViewById(R.id.tvNombre);

            ivIcono.setImageResource(icono);
            tvNombre.setText(instrumento);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (instrumentosSeleccionados.contains(instrumento)) {
                        instrumentosSeleccionados.remove(instrumento);
                        v.setSelected(false);
                    } else {
                        instrumentosSeleccionados.add(instrumento);
                        v.setSelected(true);
                    }
                }
            });

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.setMargins(12, 12, 12, 12);
            card.setLayoutParams(params);

            gridInstrumentos.addView(card);
        }
    }

    private void irSiguiente() {
        Intent intent = new Intent(this, Testgeneros.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("correo", correo);
        intent.putExtra("contrasena", contrasena);
        intent.putStringArrayListExtra("instrumentos", instrumentosSeleccionados);
        startActivity(intent);
    }
}