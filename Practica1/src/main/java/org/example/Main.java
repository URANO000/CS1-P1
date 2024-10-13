package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido !");

        //Algunos ejemplos del uso de algunos metodos

        Sistema sistema = new Sistema(); //Initializingg
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion !=0) {

            try {
                System.out.println("\n----- Sistema de Biblioteca -----");
                System.out.println("1. Agregar un libro");
                System.out.println("2. Agregar un usuario");
                System.out.println("3. Mostrar libros disponibles");
                System.out.println("4. Realizar un préstamo");
                System.out.println("5. Devolver un libro");
                System.out.println("6. Ordenar libros por título");
                System.out.println("7. Buscar libro por título");
                System.out.println("8. Buscar usuario por nombre");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1: //Nuevo libro
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = sc.nextLine();

                        System.out.print("Ingrese el nombre del autor: ");
                        String nombreAutor = sc.nextLine();

                        System.out.print("Ingrese el apellido del autor: ");
                        String apellidoAutor = sc.nextLine();

                        System.out.print("Ingrese el año de publicación: ");
                        int anioPublicacion = sc.nextInt();
                        sc.nextLine();
                        Autor autor = new Autor(nombreAutor, apellidoAutor); // Create autor
                        Libro libro = new Libro(titulo, autor, anioPublicacion, true); // Create libroo
                        sistema.agregarLibro(libro); // Add the book to the library
                        break;

                    case 2: // Uusario
                        System.out.print("Ingrese el nombre del usuario: ");
                        String nombreUsuario = sc.nextLine();

                        System.out.print("Ingrese el email del usuario: ");
                        String email = sc.nextLine();

                        System.out.print("Ingrese la fecha de registro del usuario (ej. 2024-10-09): ");
                        String fechaRegistro = sc.nextLine();

                        Usuario usuario = new Usuario(nombreUsuario, email, fechaRegistro);
                        System.out.println("Usuario registrado: " + usuario.getNombre());
                        sistema.agregarUsuario(usuario);
                        break;

                    case 3: // Show available books
                        sistema.librosDisponibles();
                        break;

                    case 4: // Loan a book to a user
                        System.out.print("Ingrese el título del libro a prestar: ");
                        String tituloPrestamo = sc.nextLine();

                        System.out.print("Ingrese el nombre del usuario: ");
                        String nombrePrestamo = sc.nextLine();

                        // Find the libro and usuario to realizar el prestamo
                        Libro libroPrestamo = sistema.buscarLibro(tituloPrestamo);
                        if (libroPrestamo == null) {
                            System.out.println("El libro no fue encontrado.");
                            break;
                        }

                        Usuario usuarioPrestamo = sistema.buscarUsuario(nombrePrestamo);
                        if (usuarioPrestamo == null) {
                            System.out.println("El usuario no fue encontrado");
                        }


                        try {
                            sistema.realizarPrestamo(usuarioPrestamo, libroPrestamo);
                            System.out.println("El libro fue prestado exitosamente!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());  //De java.lang.Throwable
                        }
                        break;

                    case 5: // Return a librooo
                        System.out.print("Ingrese el título del libro a devolver: ");
                        String tituloDevolver = sc.nextLine();

                        System.out.print("Ingrese el nombre del usuario: ");
                        String nombreDevolver = sc.nextLine();

                        Libro libroDevolver = sistema.buscarLibro(tituloDevolver);
                        if (libroDevolver == null) {
                            System.out.println("El libro no fue encontrado.");
                            sc.nextLine();
                            break;
                        }

                        Usuario usuarioDevolver = sistema.buscarUsuario(nombreDevolver);

                        try {
                            sistema.devolverLibro(usuarioDevolver, libroDevolver);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6: // Implementar el metodo de ordenar libro
                        sistema.ordenarLibro();
                        break;
                    case 7: // Search for a book by title
                        System.out.print("Ingrese el título del libro a buscar: ");
                        String tituloBuscar = sc.nextLine();

                        Libro libroBuscar = sistema.buscarLibro(tituloBuscar);
                        if (libroBuscar != null) {  //By the way, != is ! = together
                            System.out.println("Libro encontrado: " + libroBuscar.getTitulo() + " de " + libroBuscar.getAutor().getNombre());
                        } else {
                            System.out.println("El libro no fue encontrado.");
                        }
                        sc.nextLine();
                        break;
                    case 8:
                        System.out.print("Ingrese el nombre del usuario a buscar: ");
                        String nombreBuscar = sc.nextLine();

                        Usuario usuarioBuscar  = sistema.buscarUsuario(nombreBuscar);
                        if (usuarioBuscar != null) {  //By the way, != is ! = together
                            System.out.println("Usuario encontrado: " + usuarioBuscar.getNombre());
                        } else {
                            System.out.println("El usuario no fue encontrado.");
                        }
                        sc.nextLine();
                        break;
                    case 0: // Exiting the program
                        System.out.println("Saliendo del sistema de la biblioteca...!");
                        sc.close();
                        break;

                    default:
                        System.out.println("La opción no es válida. Por favor, intente nuevamente.");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("La opción no es válida. Por favor, intente nuevamente.");
                sc.nextLine(); //This part prevents it from looping forever!
            }



        }






    }
}