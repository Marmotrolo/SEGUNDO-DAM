package com.example.proyecto1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


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
        setContentView(R.layout.activity_main);
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }

    }
    private void abrirCamara() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // Acción para abrir la cámara
        startActivity(intent);  // Lanzar la actividad de la cámara
    }


    protected void onStart(){
        super.onStart();
        Intent ejemplo6 = new Intent(this, SecondActivity.class);
        ejemplo6.putExtra("Surname", "Luis");
        startActivity(ejemplo6);

    }
}