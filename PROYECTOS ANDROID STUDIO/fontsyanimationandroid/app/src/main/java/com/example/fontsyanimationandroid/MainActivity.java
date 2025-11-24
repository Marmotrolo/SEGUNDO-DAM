package com.example.fontsyanimationandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoResultado = (TextView) findViewById(R.id.text);
/*
        // Metodo 1: Usando setOnClickListener
        Button boton1 = (Button) findViewById(R.id.buttonrojo);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText("Has pulsado el botón rojo");
                textoResultado.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });

        // Botón 2 con escuchador en Java
        Button boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText("Has pulsado el botón verde");
                textoResultado.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            }
        });*/
        RadioButton radio1= (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2= (RadioButton) findViewById(R.id.radio2);
        RadioButton radio3= (RadioButton) findViewById(R.id.radio3);
        RadioButton radio4= (RadioButton) findViewById(R.id.radio4);
        RadioButton radio5= (RadioButton) findViewById(R.id.radio5);
        RadioButton radio6= (RadioButton) findViewById(R.id.radio6);
        RadioButton radio7= (RadioButton) findViewById(R.id.radio7);


    radio1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textoResultado.setText(("Lunes"));
        }
    });
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText(("Martes"));
            }
        });  radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText(("Miercoles"));
            }
        });  radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText(("Jueves"));
            }
        });  radio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText(("Viernes"));
            }
        });
        radio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText(("Sabado"));
            }
        });
        radio7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoResultado.setText(("Domingo"));
            }
        });
    }
}