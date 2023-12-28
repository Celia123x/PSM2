package com.example.pr;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String usuario;
    private String email;
    private String password;
    private String nombre;

    private ArrayList<Tarea> tareas;

    public Usuario(int id, String usuario, String email, String password, String nombre) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }


    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void addTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public void removeTarea(Tarea tarea) {
        tareas.remove(tarea);
    }


}
