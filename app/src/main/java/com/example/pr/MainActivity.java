package com.example.pr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contra;
    Button botonLogin, botonRegistrar;

    //INCLUIR SPLASH SCREEN
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuarioMeter);
        contra = findViewById(R.id.contraMeter);

        botonLogin = findViewById(R.id.botonAcceder);
        botonRegistrar = findViewById(R.id.botonRegistrar);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VisualizacionTarea.class);
                startActivity(intent);
            }
        });


    }
}