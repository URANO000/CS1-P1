package org.example;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona{
    //Additional attribute
    private String fechaRegistro;

    //Collections implementation
    private List<Usuario> usuarios = new ArrayList<>();

    //Constructor
    public Usuario(String nombre, String email, String fechaRegistro) {
        super(nombre, email); //Attributes of Persona class
        this.fechaRegistro = fechaRegistro;
    }


}
