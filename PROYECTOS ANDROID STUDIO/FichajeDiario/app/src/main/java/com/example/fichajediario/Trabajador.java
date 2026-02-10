package com.example.fichajediario;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Trabajador extends AppCompatActivity {

    private ListView lvFichajes;
    private Button btnAnadirFichaje;
    private ArrayList<String> fichajes;
    private ArrayAdapter<String> adapter;
    private static final String CHANNEL_ID = "fichajes_ch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajador);

        lvFichajes =  findViewById(R.id.lvFichajes);
        btnAnadirFichaje =  findViewById(R.id.btnAnadirFichaje);
        fichajes = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fichajes);
        lvFichajes.setAdapter(adapter);

        registerForContextMenu(lvFichajes);
        crearCanalNotificacion();

        btnAnadirFichaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirFichaje();
            }
        });
    }

    private void anadirFichaje() {
        String hora = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        fichajes.add(0, "Fichaje realizado: " + hora);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trabajador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_crear_fichaje) {
            anadirFichaje();
            return true;
        } else if (id == R.id.menu_notificar_incidencia) {
            mostrarDialogoIncidencia();
            return true;
        } else if (id == R.id.menu_cerrar_sesion) {
            mostrarDialogoCerrarSesion();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarDialogoIncidencia() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notificar Incidencia");
        builder.setMessage("¿Enviar incidencia a RRHH?");
        builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                enviarNotificacion("Incidencia", "Enviada correctamente");
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void mostrarDialogoCerrarSesion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Seguro que quieres salir?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Trabajador.this, Login.class));
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    // Menú contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "Eliminar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            fichajes.remove(info.position);
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void crearCanalNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Canal", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.createNotificationChannel(channel);
        }
    }

    private void enviarNotificacion(String titulo, String texto) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(titulo)
                .setContentText(texto)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}