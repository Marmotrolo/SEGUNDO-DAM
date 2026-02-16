package com.example.matchband;

import com.example.matchband.Usuario;
import java.util.ArrayList;

public class DataBase {

    // Lista que simula la base de datos de usuarios
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    // Usuario actualmente logueado
    private static Usuario usuarioActual = null;

    static {
        // Usuarios de prueba
        crearUsuariosPrueba();
    }

    // Crear usuarios de prueba
    private static void crearUsuariosPrueba() {
        ArrayList<String> instrumentos1 = new ArrayList<>();
        instrumentos1.add("Guitarra");
        instrumentos1.add("Voz");

        ArrayList<String> generos1 = new ArrayList<>();
        generos1.add("Rock");
        generos1.add("Indie");

        Usuario user1 = new Usuario("Luis Parrado", "luis@matchband.com", "123456",
                instrumentos1, generos1, "Busco banda");
        usuarios.add(user1);

        ArrayList<String> instrumentos2 = new ArrayList<>();
        instrumentos2.add("Batería");

        ArrayList<String> generos2 = new ArrayList<>();
        generos2.add("Metal");
        generos2.add("Rock");

        Usuario user2 = new Usuario("Carlos Ruiz", "carlos@matchband.com", "123456",
                instrumentos2, generos2, "Jamming");
        usuarios.add(user2);

        ArrayList<String> instrumentos3 = new ArrayList<>();
        instrumentos3.add("Voz");

        ArrayList<String> generos3 = new ArrayList<>();
        generos3.add("Pop");
        generos3.add("Jazz");

        Usuario user3 = new Usuario("Victoria García", "victoria@matchband.com", "123456",
                instrumentos3, generos3, "Aprender");
        usuarios.add(user3);
    }

    // Verificar si existe un correo
    public static boolean existeCorreo(String correo) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    // Login
    public static boolean login(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(contrasena)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }

    // Registrar nuevo usuario
    public static boolean registrarUsuario(Usuario usuario) {
        if (existeCorreo(usuario.getCorreo())) {
            return false; // El correo ya existe
        }
        usuarios.add(usuario);
        usuarioActual = usuario; // Auto-login después del registro
        return true;
    }

    // Obtener usuario actual
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    // Cerrar sesión
    public static void logout() {
        usuarioActual = null;
    }

    // Obtener todos los usuarios (para buscar)
    public static ArrayList<Usuario> getTodosLosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    // Buscar usuarios por instrumento
    public static ArrayList<Usuario> buscarPorInstrumento(String instrumento) {
        ArrayList<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getInstrumentos().contains(instrumento)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    // Buscar usuarios por género
    public static ArrayList<Usuario> buscarPorGenero(String genero) {
        ArrayList<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getGeneros().contains(genero)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    // Obtener recomendados (usuarios con géneros similares)
    public static ArrayList<Usuario> getRecomendados() {
        ArrayList<Usuario> recomendados = new ArrayList<>();

        if (usuarioActual == null) {
            return recomendados;
        }

        for (Usuario u : usuarios) {
            // No incluir al usuario actual
            if (u.getId().equals(usuarioActual.getId())) {
                continue;
            }

            // Verificar si comparten géneros
            for (String genero : usuarioActual.getGeneros()) {
                if (u.getGeneros().contains(genero)) {
                    recomendados.add(u);
                    break;
                }
            }
        }

        return recomendados;
    }

    // Actualizar perfil del usuario actual
    public static void actualizarPerfil(ArrayList<String> instrumentos,
                                        ArrayList<String> generos, String objetivo) {
        if (usuarioActual != null) {
            usuarioActual.setInstrumentos(instrumentos);
            usuarioActual.setGeneros(generos);
            usuarioActual.setObjetivo(objetivo);
        }
    }
}