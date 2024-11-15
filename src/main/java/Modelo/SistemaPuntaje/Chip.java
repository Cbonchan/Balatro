package Modelo.SistemaPuntaje;

public class Chip {

    private int valor;

    // Constructor
    public Chip(int valor) {
        this.valor = valor;
    }

    public Chip sumar(Chip otroChip) {
        return new Chip(this.valor + otroChip.valorNumerico());
    }

    // Solo usar en Puntajes, si se usa afuera, se rompe pilar
    // Recordar: Lo que pasa en Chip queda en Chip
    public int valorNumerico() {
        return this.valor;
    }
}
