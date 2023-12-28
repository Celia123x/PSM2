package com.example.pr;

//package org.dizitart.nitrite.demo.Model;

public class DataBase {

    //private static final String DATABASE_NAME = "tareas.db";
    //private static Nitrite nitrite;
    //private static NitriteManager;
    //private static ObjectRepository<Tarea> tareaRepository;

    /*public static void init(Context context) {
        if (nitrite == null || tareaRepository == null) {
            nitrite = Nitrite.builder()
                    .compressed()
                    .filePath(context.getDatabasePath(DATABASE_NAME).toString())
                    .openOrCreate();

            tareaRepository = nitrite.getRepository(Tarea.class);
        }
    }

    public static void close() {
        if (nitrite != null) {
            nitrite.close();
        }
    }

    public static void insertTarea(Tarea tarea) {
        if (tareaRepository != null) {
            tareaRepository.insert(tarea);
        }
    }

    public static Iterable<Tarea> getTodasTareas() {
        if (tareaRepository != null) {
            return tareaRepository.find().toList();
        }
        return null;
    }*/
}
