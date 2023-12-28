package com.example.pr;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Gestionar {

    private static final String NOMBRE_ARCHIVO_JSON = "datos.json";
    private Context context;

    public Gestionar(Context context) {
        this.context = context;
    }

    private ArrayList<Usuario> cargarDatos() {
        try {
            // Lee el contenido del archivo JSON
            String json = leerArchivo();

            if (json != null) {
                // Convierte el JSON en una lista de usuarios
                return parsearJsonUsuarios(json);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String leerArchivo() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(context.openFileInput(NOMBRE_ARCHIVO_JSON)))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, devuelve null
            return null;
        }
    }

    public void inicializarApp() {
        // Intenta cargar datos desde el archivo JSON
        ArrayList<Usuario> listaUsuarios = cargarDatos();

        if (listaUsuarios == null) {
            // Si no hay datos, inicializa con datos de ejemplo
            inicializarDatosEjemplo();
        }

        // Puedes agregar más lógica de inicialización según sea necesario
    }





    private ArrayList<Usuario> parsearJsonUsuarios(String json) throws JSONException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("id");
            String username = jsonObject.getString("username");
            String email = jsonObject.getString("email");
            String password = jsonObject.getString("password");
            String nombre = jsonObject.getString("nombre");

            Usuario usuario = new Usuario(id, username, email, password, nombre);
            listaUsuarios.add(usuario);
        }

        return listaUsuarios;
    }

    private void inicializarDatosEjemplo() {
        // Crea una lista de usuarios de ejemplo
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario(1, "pepe123", "pepe@uva.es", "pepe", "Pepito"));
        listaUsuarios.add(new Usuario(2, "juan456", "juan@uva.es", "juan", "Juanito"));

        // Guarda la lista de usuarios en el archivo JSON
        guardarDatos(listaUsuarios);
    }

    private void guardarDatos(ArrayList<Usuario> listaUsuarios) {
        try {
            // Convierte la lista de usuarios a JSON
            String json = convertirListaUsuariosAJson(listaUsuarios);

            // Escribe el JSON en el archivo
            escribirArchivo(json);

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    private String convertirListaUsuariosAJson(ArrayList<Usuario> listaUsuarios) throws JSONException {
        JSONArray jsonArray = new JSONArray();

        for (Usuario usuario : listaUsuarios) {
            JSONObject jsonObject = new JSONObject();
            /*jsonObject.put("id", usuario.getId());
            jsonObject.put("username", usuario.getUsername());
            jsonObject.put("email", usuario.getEmail());
            jsonObject.put("password", usuario.getPassword());
            jsonObject.put("nombre", usuario.getNombre());*/

            jsonArray.put(jsonObject);
        }

        return jsonArray.toString();
    }

    private void escribirArchivo(String json) throws IOException {
        try (FileOutputStream fos = context.openFileOutput(NOMBRE_ARCHIVO_JSON, Context.MODE_PRIVATE)) {
            fos.write(json.getBytes());
        }
    }

    public boolean iniciarSesion(String username, String password) {
        // Implementa la lógica de inicio de sesión aquí
        return false;
    }

    public void crearUsuario(String username, String email, String password, String nombre) {
        // Implementa la lógica de creación de usuario aquí
    }

    public void crearTarea(int idUsuario, String asunto, String descripcion, String fecha, String prioridad) {
        // Implementa la lógica de creación de tarea aquí
    }



}
