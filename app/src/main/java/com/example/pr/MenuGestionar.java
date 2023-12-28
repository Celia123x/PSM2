package com.example.pr;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuGestionar{
    public static void manejarMenu(BottomNavigationView bottomNavigationView, final AppCompatActivity activity) {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent = null;

                        // Maneja los clics en el menú
                        if (item.getItemId() == R.id.boton1) {
                            // Si ya estás en CreacionTarea, nada
                            if (!(activity instanceof CreacionTarea)) {
                                intent = new Intent(activity, CreacionTarea.class);
                            }
                        } else if (item.getItemId() == R.id.boton2) {
                            if (!(activity instanceof VisualizacionTarea)) {
                                intent = new Intent(activity, VisualizacionTarea.class);
                            }
                        } else if (item.getItemId() == R.id.boton3) {
                            // Si ya estás en Registrar, no hagas nada
                            if (!(activity instanceof Registrar)) {
                                intent = new Intent(activity, todasTareas.class);
                            }
                        } else if (item.getItemId() == R.id.boton4) {
                            if (!(activity instanceof Registrar)) {
                                intent = new Intent(activity, Ajustes.class);
                            }

                        }

                        if (intent != null) {
                            activity.startActivity(intent);
                            activity.finish(); // Opcional, dependiendo de tu flujo de navegación
                        }

                        return true;
                    }
                }
        );
    }
}



/*
public class MenuGestionar extends AppCompatActivity {
    // Definir variables finales para los IDs de los botones
    private static final int ID_BOTON1 = R.id.boton1;
    private static final int ID_BOTON2 = R.id.boton2;
    private static final int ID_BOTON3 = R.id.boton3;
    private static final int ID_BOTON4 = R.id.boton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gestionar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.barraNavegacion);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent = null;
                        if (item.getItemId() == ID_BOTON1) {
                            intent = new Intent(MenuGestionar.this, CreacionTarea.class);
                        } else if (item.getItemId() == ID_BOTON2) {
                            intent = new Intent(MenuGestionar.this, VisualizacionTarea.class);
                        } else if (item.getItemId() == ID_BOTON3) {
                            intent = new Intent(MenuGestionar.this, Registrar.class);
                        } else if (item.getItemId() == ID_BOTON4) {

                        }


                        if (intent != null) {
                            startActivity(intent);
                            finish(); // Opcional, dependiendo de tu flujo de navegación
                        }

                        return true;
                    }
                }
        );
    }
}*/



