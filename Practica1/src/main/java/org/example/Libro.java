package org.example;

public class Libro {
    //Attributes
    private String titulo;
    private Autor autor;  //This is type author
    private int anioPublicacion;
    private boolean disponible;

    //Constructor

    public Libro(String titulo, Autor autor, int anioPublicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;

        //anade autor
        autor.agregarLibro(this);
    }

    //Getters & setters

    public String getTitulo() {
        return titulo;
    }

    public void setLibro(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
