package com.example.fichajediario;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class RRHH extends AppCompatActivity {

    private GridView gvTrabajadores;
    private ArrayList<String> trabajadores;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrhh);

        gvTrabajadores = (GridView) findViewById(R.id.gvTrabajadores);

        trabajadores = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, trabajadores);
        gvTrabajadores.setAdapter(adapter);

        registerForContextMenu(gvTrabajadores);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rrhh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_crear_trabajador) {
            mostrarDialogoCrear();
        } else if (id == R.id.menu_cerrar_sesion_rrhh) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Acciones");
        // Añadimos la opción de eliminar (ID = 1)
        menu.add(0, 1, 0, "Eliminar Trabajador");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == 1) { //
            trabajadores.remove(info.position);
            // Refresca la pantalla
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Trabajador eliminado", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    private void mostrarDialogoCrear() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nuevo Trabajador");
        builder.setMessage("¿Añadir uno nuevo?");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                trabajadores.add("Nuevo Trabajador " + trabajadores.toArray().length+1);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }
}