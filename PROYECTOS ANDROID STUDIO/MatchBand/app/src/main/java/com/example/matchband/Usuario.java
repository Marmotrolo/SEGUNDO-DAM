package com.example.matchband;

import java.util.ArrayList;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String contrasena;
    private ArrayList<String> instrumentos;
    private ArrayList<String> generos;
    private String objetivo;
    private String fotoPerfil; // URL o null

    // Constructor vacío
    public Usuario() {
        this.instrumentos = new ArrayList<>();
        this.generos = new ArrayList<>();
    }

    // Constructor completo
    public Usuario(String nombre, String correo, String contrasena,
                   ArrayList<String> instrumentos, ArrayList<String> generos, String objetivo) {
        this.id = generarId();
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.instrumentos = instrumentos != null ? instrumentos : new ArrayList<>();
        this.generos = generos != null ? generos : new ArrayList<>();
        this.objetivo = objetivo;
        this.fotoPerfil = null;
    }

    // Generar ID simple (en MongoDB esto se hará automáticamente)
    private String generarId() {
        return "user_" + System.currentTimeMillis();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public ArrayList<String> getInstrumentos() { return instrumentos; }
    public void setInstrumentos(ArrayList<String> instrumentos) { this.instrumentos = instrumentos; }

    public ArrayList<String> getGeneros() { return generos; }
    public void setGeneros(ArrayList<String> generos) { this.generos = generos; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", instrumentos=" + instrumentos +
                ", generos=" + generos +
                ", objetivo='" + objetivo + '\'' +
                '}';
    }
}