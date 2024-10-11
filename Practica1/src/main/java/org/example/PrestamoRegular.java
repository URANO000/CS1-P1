package org.example;

public class PrestamoRegular extends Prestamo{
    //Attributes for loan logic. Example- Days and cost per day
    private static final int interesDiario = 500;

    //Constructor

    public PrestamoRegular(int dias) {
        super(dias);
    }

    //Apply methods

    @Override
    public double calcularCosto() {
        return dias * interesDiario;
    }
}
