package org.example;

public class Persona {
    //Attributes
    protected String nombre;
    protected String email;

    //Constructor

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    //Getters & setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
