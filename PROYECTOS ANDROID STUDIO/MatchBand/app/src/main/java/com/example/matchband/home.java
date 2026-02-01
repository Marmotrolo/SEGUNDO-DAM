package com.example.matchband;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.matchband.R;

public class home extends AppCompatActivity {

    private LinearLayout llRecomendados;
    private LinearLayout llAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        llRecomendados = findViewById(R.id.llRecomendados);
        llAnuncios = findViewById(R.id.llAnuncios);

        // Agregar músicos recomendados de ejemplo
        agregarMusicoRecomendado("Carlos Ruiz", "Guitarra", null); // Mostrará "C"
        agregarMusicoRecomendado("Victoria García", "Voz", null); // Mostrará "V"
        agregarMusicoRecomendado("Mr White", "Batería", null); // Mostrará "M"

        // Agregar anuncios de ejemplo
        agregarAnuncio(null, "Pablo Parrado", "Hace 2h",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit aliquet interdum, lacus faucibus habitant egestas massa sed luctus orci fringilla, urna integer viverra felis dapibus est dictum accumsan",
                12, 5);
    }

    private void agregarMusicoRecomendado(String nombre, String instrumento, String urlFoto) {
        View card = getLayoutInflater().inflate(R.layout.item_musico_recomendado, llRecomendados, false);

        TextView tvNombre = card.findViewById(R.id.tvNombreMusico);
        TextView tvInstrumento = card.findViewById(R.id.tvInstrumento);
        TextView tvInicial = card.findViewById(R.id.tvInicial);
        ImageView ivFoto = card.findViewById(R.id.ivFotoPerfil);

        tvNombre.setText(nombre);
        tvInstrumento.setText(instrumento);

        // Obtener la primera letra del nombre
        String inicial = nombre.substring(0, 1).toUpperCase();
        tvInicial.setText(inicial);

        // Si hay foto, mostrarla (esto lo harás con Glide/Picasso más adelante)
        if (urlFoto != null && !urlFoto.isEmpty()) {
            // Glide.with(this).load(urlFoto).into(ivFoto);
            // ivFoto.setVisibility(View.VISIBLE);
            // tvInicial.setVisibility(View.GONE);
        }

        llRecomendados.addView(card);
    }

    private void agregarAnuncio(String urlavatar, String nombre, String tiempo, String texto, int likes, int comentarios) {
        View card = getLayoutInflater().inflate(R.layout.item_anuncio, llAnuncios, false);

        ImageView ivFoto = card.findViewById(R.id.ivFotoPerfilanuncio);
        TextView tvNombre = card.findViewById(R.id.tvNombreUsuario);
        TextView tvInicialanuncio = card.findViewById(R.id.tvInicialanuncio);

        TextView tvTiempo = card.findViewById(R.id.tvTiempo);
        TextView tvTexto = card.findViewById(R.id.tvTextoAnuncio);
        TextView tvLikes = card.findViewById(R.id.tvLikes);
        TextView tvComentarios = card.findViewById(R.id.tvComentarios);

        tvNombre.setText(nombre);
        tvTiempo.setText(tiempo);
        tvTexto.setText(texto);
        tvLikes.setText(String.valueOf(likes));
        tvComentarios.setText(String.valueOf(comentarios));

        String inicial = nombre.substring(0, 1).toUpperCase();
        tvInicialanuncio.setText(inicial);
        // Si hay foto, mostrarla (esto lo harás con Glide/Picasso más adelante)
        if (urlavatar != null && !urlavatar.isEmpty()) {
            // Glide.with(this).load(urlFoto).into(ivFoto);
            // ivFoto.setVisibility(View.VISIBLE);
            // tvInicial.setVisibility(View.GONE);
        }


        llAnuncios.addView(card);
    }
}