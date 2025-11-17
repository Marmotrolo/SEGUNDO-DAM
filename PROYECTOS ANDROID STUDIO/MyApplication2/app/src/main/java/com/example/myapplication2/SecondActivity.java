package com.example.myapplication2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = getIntent().getExtras();

        TextView mitexto = (TextView) findViewById(R.id.texto);
        mitexto.setText("Nuevo texto para mostrar");

        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        mitexto.startAnimation(miAnimacion);


    }
}

