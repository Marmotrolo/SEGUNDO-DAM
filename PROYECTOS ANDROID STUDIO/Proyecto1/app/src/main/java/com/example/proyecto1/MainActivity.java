package com.example.proyecto1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.second_activity);


        //Intent ejemplo= new Intent (this, SecondActivity.class);
        //startActivity(ejemplo);
        /*Intent ejemplo2= new Intent (Intent.ACTION_VIEW);
        ejemplo2.setData(Uri.parse("https://chatgpt.com/"));
        startActivity(ejemplo2);*/
       /*
        Intent ejemplo3= new Intent((Intent.ACTION_CALL));
        ejemplo3.setData(Uri.parse("tel:NÚMERO"));
        startActivity(ejemplo3);
*/
        /*Intent ejemplo4= new Intent((Intent.ACTION_CALL));
        startActivity(ejemplo4);*/

        // super.onStart();
        // Verificar si el permiso de cámara está concedido

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
        Log.i("pablo", "Permiso concedido");
           abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }
        Log.i("pablo", "Activity creada");
    }
    private void abrirCamara() {

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // Acción para abrir la cámara
        startActivity(intent);  //
        // Lanzar la actividad de la cámara
        Log.i("pablo" , "Abierta");

    }



    protected void onStart() {
        super.onStart();
        Intent ejemplo6 = new Intent(this, SecondActivity.class);
        ejemplo6.putExtra("Surname", "Luis");
        // startActivity(ejemplo6);

    }
}