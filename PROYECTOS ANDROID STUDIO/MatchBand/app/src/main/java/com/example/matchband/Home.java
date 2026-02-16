package com.example.matchband;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.matchband.DataBase;
import com.example.matchband.Usuario;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private LinearLayout llRecomendados;
    private LinearLayout llAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        llRecomendados = findViewById(R.id.llRecomendados);
        llAnuncios = findViewById(R.id.llAnuncios);

        cargarRecomendados();
        cargarAnuncios();
    }

    private void cargarRecomendados() {
        // TODO: Cambiar por llamada a MongoDB
        ArrayList<Usuario> recomendados = DataBase.getRecomendados();
        for (Usuario usuario : recomendados) {
            String instrumento = usuario.getInstrumentos().isEmpty() ?
                    "Músico" : usuario.getInstrumentos().get(0);
            agregarMusicoRecomendado(usuario.getNombre(), instrumento, null);
        }

        // Si no hay recomendados, mostrar todos
        if (recomendados.isEmpty()) {
            ArrayList<Usuario> todos = DataBase.getTodosLosUsuarios();
            for (Usuario usuario : todos) {
                if (!usuario.getId().equals(DataBase.getUsuarioActual().getId())) {
                    String instrumento = usuario.getInstrumentos().isEmpty() ?
                            "Músico" : usuario.getInstrumentos().get(0);
                    agregarMusicoRecomendado(usuario.getNombre(), instrumento, null);
                }
            }
        }
    }

    private void cargarAnuncios() {
        // Anuncios de prueba (TODO: Cambiar por MongoDB)
        agregarAnuncio("Luis Parrado", "Hace 2h",
                "Busco guitarrista para banda de rock alternativo. Influencias: Arctic Monkeys, The Strokes. Ensayos los viernes.",
                12, 5, null);

        agregarAnuncio("Victoria García", "Hace 5h",
                "Cantante disponible para colaboraciones. Especialidad en jazz y soul. Interesada en proyectos creativos.",
                8, 3, null);
    }

    private void agregarMusicoRecomendado(String nombre, String instrumento, String urlFoto) {
        View card = getLayoutInflater().inflate(R.layout.item_musico_recomendado, llRecomendados, false);

        TextView tvNombre = card.findViewById(R.id.tvNombreMusico);
        TextView tvInstrumento = card.findViewById(R.id.tvInstrumento);
        TextView tvInicial = card.findViewById(R.id.tvInicial);
        ImageView ivFoto = card.findViewById(R.id.ivFotoPerfil);

        tvNombre.setText(nombre);
        tvInstrumento.setText(instrumento);

        String inicial = nombre.substring(0, 1).toUpperCase();
        tvInicial.setText(inicial);

        if (urlFoto != null && !urlFoto.isEmpty()) {
            // TODO: Cargar con Glide cuando conectes MongoDB
            // Glide.with(this).load(urlFoto).into(ivFoto);
            // ivFoto.setVisibility(View.VISIBLE);
            // tvInicial.setVisibility(View.GONE);
        }

        llRecomendados.addView(card);
    }

    private void agregarAnuncio(String nombre, String tiempo, String texto,
                                int likes, int comentarios, String urlFoto) {
        View card = getLayoutInflater().inflate(R.layout.item_anuncio, llAnuncios, false);

        TextView tvNombre = card.findViewById(R.id.tvNombreUsuario);
        TextView tvTiempo = card.findViewById(R.id.tvTiempo);
        TextView tvTexto = card.findViewById(R.id.tvTextoAnuncio);
        TextView tvLikes = card.findViewById(R.id.tvLikes);
        TextView tvComentarios = card.findViewById(R.id.tvComentarios);
        TextView tvInicial = card.findViewById(R.id.tvInicial);

        tvNombre.setText(nombre);
        tvTiempo.setText(tiempo);
        tvTexto.setText(texto);
        tvLikes.setText(String.valueOf(likes));
        tvComentarios.setText(String.valueOf(comentarios));

        String inicial = nombre.substring(0, 1).toUpperCase();
        tvInicial.setText(inicial);

        if (urlFoto != null && !urlFoto.isEmpty()) {
            // TODO: Cargar con Glide
        }

        llAnuncios.addView(card);
    }
}