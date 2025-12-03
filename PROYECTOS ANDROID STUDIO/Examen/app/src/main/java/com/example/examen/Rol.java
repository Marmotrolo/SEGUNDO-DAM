package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent; // Necesitas esto
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Rol extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rol);
//Declaro los radio buttons y botones de ingreso y vuelta
        RadioButton radioConductor = findViewById(R.id.radioConductor);
        RadioButton radioAdmin = findViewById(R.id.radioAdministrador);
        Button botonvolver = findViewById(R.id.botonVolver);
//logica para boton de volver
        botonvolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentvolver = new Intent(Rol.this, MainActivity.class);
                startActivity(intentvolver);
            }
        });
//logica botones si es radioconductor o radioadmin va a una activity u otra
        Button botoningreso = (Button) findViewById(R.id.botoncontinuar);
        botoningreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioConductor.isChecked()) {
                    Intent intentconductor = new Intent(Rol.this, Conductor.class);
                    startActivity(intentconductor);
                } else if (radioAdmin.isChecked()) {
                    Intent intentadmin = new Intent(Rol.this, Administrador.class);
                    startActivity(intentadmin);
                } else {

                }
            }
        });

    }
}