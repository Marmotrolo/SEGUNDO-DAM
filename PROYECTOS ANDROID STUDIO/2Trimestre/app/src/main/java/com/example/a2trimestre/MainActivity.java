package com.example.a2trimestre;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Datos[] datos = new Datos[]{
                new Datos("Linea superior 1", "Linea inferior 1"),
                new Datos("Linea superior 2", "Linea inferior 2"),
                new Datos("Linea superior 3", "Linea inferior 3"),
                new Datos("Linea superior 4", "Linea inferior 4"),
                new Datos("Linea superior 5", "Linea inferior 5")
        };
        ListView listado = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);


        String[] opciones = {
                "Dark Souls",
                "Dark Souls II",
                "Dark Souls III",
                "Demon's Souls",
                "Bloodborne",
                "Sekiro: Shadows Die Twice",
                "Elden Ring",
                "Lies of P",
                "Nioh",
                "Nioh 2"
        };
        /*AutoCompleteTextView textoLeido = (AutoCompleteTextView) findViewById(R.id.miTexto);
        ArrayAdapter<String> adapador = new ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, opciones);
        textoLeido.setAdapter(adapador);*/
        /*SeekBar miControl = (SeekBar) findViewById(R.id.miSeekBar);
        miControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("MiSeekBar","Valor progreso:"+ seekBar.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("MiseekBar","Valor final de:"+ seekBar.getProgress());
            }
        });*/


      /*  RatingBar controlRating =  (RatingBar) findViewById(R.id.myRating);
        controlRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("Rating","Valor de rating: "+rating);
            }
        });*/






       /* GridView listado = (GridView) findViewById(R.id.miGrid);
        final String[] datos = new String[]{"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6","Elemento 7","Elemento 8"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);


        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(String) parent.getItemAtPosition(position));
            }
        });*/

       /* Spinner listaSpinner = (Spinner) findViewById(R.id.miSpinner);
        final String[] datosSpinner = new String[]{"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5"};
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosSpinner);
        listaSpinner.setAdapter(adaptadorSpinner);

        listaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/


    }
}