package com.example.pr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//import org.dizitart.no2.Nitrite;
//import org.dizitart.no2.objects.ObjectRepository;


public class Registrar extends AppCompatActivity {
    EditText usuarioR, emailR, contraR, nombreR;
    Button botonRegistro;

    //private Nitrite db;
    //private ObjectRepository<Usuario> userRepository;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        usuarioR = findViewById(R.id.usuarioRMeter);
        contraR = findViewById(R.id.contraRMeter);
        emailR = findViewById(R.id.correoRMeter);
        nombreR = findViewById(R.id.nombreUsuarioMeter);
        botonRegistro = findViewById(R.id.registrarseIr);

        // Inicializa la base de datos Nitrite y el repositorio de usuarios
        //db = Nitrite.builder().openOrCreate();
        //userRepository = db.getRepository(Usuario.class);

    }

}