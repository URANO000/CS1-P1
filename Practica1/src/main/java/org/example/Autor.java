package org.example;

import java.util.*;

public class Autor {
    //Attributes
    private String nombre;
    private String apellido;

    //Create Libro list, type Libro
    private List<Libro> libros = new ArrayList<>();

    //Constructor

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.libros = libros;
    }

    //To link book to author
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    //Getters & setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //ToString

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido;
    }
}
