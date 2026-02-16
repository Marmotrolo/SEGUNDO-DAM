package com.example.matchband;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.matchband.DataBase;
import com.example.matchband.Usuario;
import java.util.ArrayList;

public class Testobjetivos extends AppCompatActivity {

    private LinearLayout llObjetivos;
    private Button btnComenzar;
    private TextView tvOmitir;
    private ImageButton btnAtras;

    private String objetivoSeleccionado = "";
    private String nombre, correo, contrasena;
    private ArrayList<String> instrumentos, generos;

    private View cardSeleccionado = null;

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

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarOnboarding();
            }
        });

        tvOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarOnboarding();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void crearOpcionesObjetivo() {
        String[][] objetivos = {
                {"Busco banda", "Quiero unirme a un proyecto serio", String.valueOf(R.drawable.ic_band)},
                {"Jamming", "Tocar casualmente sin compromiso", String.valueOf(R.drawable.ic_bass)},
                {"Aprender", "Mejorar mi técnica y conocimientos", String.valueOf(R.drawable.ic_music)}
        };

        for (String[] objetivo : objetivos) {
            String titulo = objetivo[0];
            String descripcion = objetivo[1];
            int icono = Integer.parseInt(objetivo[2]);

            View card = getLayoutInflater().inflate(R.layout.item_opcion_objetivo, llObjetivos, false);

            ImageView ivIcono = card.findViewById(R.id.ivIconoObjetivo);
            TextView tvTitulo = card.findViewById(R.id.tvTituloObjetivo);
            TextView tvDescripcion = card.findViewById(R.id.tvDescripcionObjetivo);

            ivIcono.setImageResource(icono);
            tvTitulo.setText(titulo);
            tvDescripcion.setText(descripcion);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cardSeleccionado != null) {
                        cardSeleccionado.setSelected(false);
                    }
                    v.setSelected(true);
                    cardSeleccionado = v;
                    objetivoSeleccionado = titulo;
                }
            });

            llObjetivos.addView(card);
        }
    }

    private void finalizarOnboarding() {
        // Crear el usuario
        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena,
                instrumentos, generos, objetivoSeleccionado);

        // TODO: Cambiar por llamada a MongoDB
        boolean registrado = DataBase.registrarUsuario(nuevoUsuario);

        if (registrado) {
            Toast.makeText(this, "¡Bienvenido a MatchBand, " + nombre + "! 🎸", Toast.LENGTH_SHORT).show();

            // Ir al MainActivity
            Intent intent = new Intent(this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Error al crear la cuenta", Toast.LENGTH_SHORT).show();
        }
    }
}