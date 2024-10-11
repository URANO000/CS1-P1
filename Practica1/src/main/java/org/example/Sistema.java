package org.example;

import java.util.*;

public class Sistema {
    //I will use this class to implement the extra functionalities like Collections and methods
    //This class is only dedicated to that, hence why I chose to do it on a whole separate class

    //Collections implementation for libro :0 Colecciones genericas
    private ArrayList<Libro> libros = new ArrayList<>();
    private Set<Libro> librosUnicos = new HashSet<>();

    //Collections implementation for Usuario
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Map<Usuario, List<Libro>> prestamos = new HashMap<>();  //This is a relationship between Usuario and libros prestados. Keys

    //Operations to order and look for elemnts on the lists!!! Some methods. I choose to ask ther user
    //First adding operations
    public void agregarLibro(Libro libro) {     //Type libro so it can add all attributes too
        libros.add(libro);
    }

    public void agregarLibroUnico(Libro libroUnico) { //Boolean because it will return false if the book exists
        librosUnicos.add(libroUnico);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    //Order with sort

    public void ordenarLibro() {
        Collections.sort(libros, Comparator.comparing(Libro::getTitulo)); //Here we are ordering the list libros in asc order by the title utilizing comparator class
    }

    public void ordernarUsuario() {
        Collections.sort(usuarios, Comparator.comparing(Usuario::getNombre)); //Note: Because it is an Usuario type, you can't just sort without comparing
    }

    //Look for elements. I will be using a loop, looking by name since the directions don't specify

    public Libro buscarLibro(String titulo) {
        for (Libro libro:libros) {
            if (libro.getTitulo().equals(titulo)) {   //Equals to compare
                return libro;
            }
        }
        return null; //If the title doesn't match anything in the arrayList
    }

    public Usuario buscarUsuario(String nombre) {  //Same logic for Usuario lookup too
        for (Usuario usuario: usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public Libro buscarLibroUnico(String titulo) {
        for (Libro libro: librosUnicos) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;

    }

    //Here I'm going to associate the values in Map. I checked this in Oracle's documentation for JDK 11
    public void prestamoLibros(Usuario usuario, List<Libro> libroprestamo) {
        prestamos.put(usuario, libroprestamo);
    }


    //LOOP libros disponibles

    public void librosDisponibles() {
        int counter = 0;
        for (Libro libro: libros) {
            if (libro.isDisponible()) {
                System.out.println("Listado de libros disponibles: ");
                System.out.println("Libro: " + counter+1 + "\n" +  " Titulo: " + libro.getTitulo() + "\n" + " Autor: " + libro.getAutor() + "\n");
            }

        }

    }

    //This is to realizar prestamos of books. Used Map methods from docs.oracle.com

    public void realizarPrestamo(Usuario usuario, Libro libro) throws Exception {
        //Check if usuario no registrado
        if (!usuarios.contains(usuario)) {
            throw new Exception("El usuario no está registrado en el sistema");
        }

        if (!libros.contains(libro)) {  //if list does not contain the specific book
            throw new Exception("El libro no está en disponible en la biblioteca.");
    }
        if (!libro.isDisponible()) {  //If the Disponible = false then this
            throw new Exception("El libro no está disponible.");
    }
        libro.setDisponible(false);  //If everything works, then the Disponible set as false since book was loaned!

        //Now to implement the functions from prestamo
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el tipo de préstamo");
        System.out.println("1. Préstamo regular");
        System.out.println("2. Préstamo Urgente");
        opcion = sc.nextInt();

        //Now plug it into the calcularCosto
        Prestamo prestamo;

        switch (opcion) {
            case 1:
                prestamo = new PrestamoRegular(pedirDias());
                break;
            case 2:
                prestamo = new PrestamoUrgente(pedirDias());
                break;
            default:
                throw new IllegalArgumentException("Opción no es v[alida.");
        }
        //Now to display it to the uuser
        double costo = prestamo.calcularCosto();
        System.out.println("El costo del préstamo es: " + costo);
        //
        prestamos.computeIfAbsent(usuario, k -> new ArrayList<>()).add(libro);  //Clases in java.util, I used - and >
        //This basically means we are adding the specific book to the map, using the two keys and making them related
        System.out.println("Préstamo realizado con éxito");



    }

    public void devolverLibro(Usuario usuario, Libro libro) {
        if (prestamos.containsKey(usuario) && prestamos.get(usuario).contains(libro)) {
            prestamos.get(usuario).remove(libro);
            libro.setDisponible(true); //Now the book is available again
        }
        //All this does is, if prestamos contains user, and this user has a book, then remove book from usuario and therefore loan
    }

    //Doing this to calculate the number of days to calculate which loan I should give out
    public int pedirDias() {
        int dias = 0;
        //Call Scanner class to read the user input in console
        Scanner sc = new Scanner(System.in);

        //Manage Exceptions in case user doesn't actually add any valid numbers
        boolean numValido = false;

        while (!numValido) {
            try {
                System.out.print("Ingrese la cantidad de días que tendrá su libro: ");
                dias = sc.nextInt();
                numValido = true;  //To exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor válido");
                sc.next();
            }
        }
        sc.close(); //We close the scanner outside the loop to avoid an exception

        return dias;


    }



}
