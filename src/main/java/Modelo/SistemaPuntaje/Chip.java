package Modelo.SistemaPuntaje;

public class Chip {

    private int valor;

    // Constructor
    public Chip(int valor) {
        this.valor = valor;
    }

    // Métodos
    public Chip sumar(Chip otroChip) {
        return new Chip(this.valor + otroChip.valorNumerico());
    }

    // Post: Multiplica el valor de los chips
    public int multiplicarCon(int multiplicador) {
        return  this.valor * multiplicador;
    }

    // Post: Cambia el chip por otro
    public void cambiarChip(int valor) {
        this.valor = valor;
    }

    // Solo usar en Puntajes, si se usa afuera, se rompe pilar
    // Recordar: Lo que pasa en Chip queda en Chip
    public int valorNumerico() {
        return this.valor;
    }


}
