package org.example;

public class PrestamoUrgente extends Prestamo{
    //Attributes
    private static final int interesDiario = 1000; //El costo diario aumenta al ser un prestamo urgente
    private static final int extra = 1500;  //Tarifa extra por retraso, por ejemplo

    //Constructor
    public PrestamoUrgente(int dias) {
        super(dias);
    }

    //Implement method with Override

    @Override
    public double calcularCosto() {
        return dias * interesDiario + extra;
    }
}
