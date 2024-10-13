package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Prestamo {
    protected int dias; //

    //Constructor
    public Prestamo(int dias) {
        this.dias = dias;
    }

    //Getters & setters

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    //Methods
    public abstract double calcularCosto();


}
