package com.example.pr;

//package org.dizitart.nitrite.demo.Model;
import android.content.Context;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.objects.ObjectRepository;

public class DataBase {

    private static final String DATABASE_NAME = "tareas.db";
    private static Nitrite db;

    private static ObjectRepository<Tarea> tareaRepository;
    public static void init(Context context) {
        if (db == null) {
            db = Nitrite.builder()
                    .compressed()
                    .filePath(context.getDatabasePath(DATABASE_NAME).toString())
                    .openOrCreate();
        }
        if (tareaRepository == null) {
            tareaRepository = db.getRepository(Tarea.class);
        }
    }

    public static void close() {
        if (db != null) {
            db.close();
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
    }
}
