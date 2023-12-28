package com.example.pr;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

public class todasTareas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_tareas);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.botones_menu, menu);
        return true;
    }


}