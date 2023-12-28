package com.example.pr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VisualizacionTarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion_tarea);


        BottomNavigationView bottomNavigationView = findViewById(R.id.barraNavegacion);
        MenuGestionar.manejarMenu(bottomNavigationView, this);

    }
}



