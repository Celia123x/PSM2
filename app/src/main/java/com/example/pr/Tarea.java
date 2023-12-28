package com.example.pr;

public class Tarea {
    private int id;
    private String asunto, descripcion, prioridad;
    private String fecha;

    public Tarea(String asunto, String descripcion, String fecha, String prioridad) {
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
    }

    public String getAsunto() {
        return asunto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public String getPrioridad() {
        return prioridad;
    }

    public int getIdTarea() {
        return id;
    }
}

