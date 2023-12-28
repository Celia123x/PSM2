package com.example.pr;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class CreacionTarea extends AppCompatActivity {
    private EditText fechaMeter, asunto, descripcion;
    private Button botonDatePicker, botonCrearTarea;

    private Spinner prioridadSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_tarea);


        fechaMeter = findViewById(R.id.fechaMeter);
        asunto = findViewById(R.id.asuntoMeter);
        descripcion = findViewById(R.id.descripcionMeter);
        botonDatePicker = findViewById(R.id.botonDatePicker);
        prioridadSpinner = findViewById(R.id.prioridadSpinner);
        botonCrearTarea = findViewById(R.id.botonCrearTarea);

        botonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        botonCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearTarea();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.barraNavegacion);
        MenuGestionar.manejarMenu(bottomNavigationView, this);

    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(selectedYear, selectedMonth, selectedDay);

                if(selectedDate.getTimeInMillis() >= calendar.getTimeInMillis()){ //fecha seleccionada mayor a la actual
                    String finalDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    fechaMeter.setText(finalDate);
                }else{
                    //si no, se muestra un toast
                    Toast.makeText(CreacionTarea.this, "ERROR DATE", Toast.LENGTH_SHORT).show();

                }




            }
        }, year, month, dayOfMonth);

        //FECHA MÍNIMA
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());


        datePickerDialog.show();
    }

    private void crearTarea() {
        String asuntoT = asunto.getText().toString();
        String descripcionT = descripcion.getText().toString();
        String fechaT = fechaMeter.getText().toString();
        String prioridadT = prioridadSpinner.getSelectedItem().toString();

        // Check if any of the fields are empty
        if (asuntoT.isEmpty() || descripcionT.isEmpty() || fechaT.isEmpty()) {
            Toast.makeText(this, "ERROR. Introduce todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        Tarea nuevaTarea = new Tarea(asuntoT, descripcionT, fechaT, prioridadT);

        //Usuario usuario = obtenerUsuarioPorId(idUsuario);
        Usuario usuario = new Usuario(1, "pepe123", "pepe@uva.es", "pepe", "Pepito");

        if(usuario != null){
            usuario.addTarea(nuevaTarea);
            Toast.makeText(this, "Tarea creada y asignada al usuario", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();

        }


        /*usuario.addTarea(nuevaTarea);

        Toast.makeText(this, "Creada", Toast.LENGTH_SHORT).show();

        ArrayList<Tarea> holaTarea = usuario.getTareas();
        for(Tarea e : holaTarea){

            System.out.println("Asunto: " + e.getAsunto() +
                    ", Descripcion: " + e.getDescripcion() +
                    ", Fecha: " + e.getFecha() +
                    ", Prioridad: " + e.getPrioridad());
        }*/

    }

}