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

    public int multiplicarCon(int multiplicador) {
        return  this.valor * multiplicador;
    }

    // Solo usar en Puntajes, si se usa afuera, se rompe pilar
    // Recordar: Lo que pasa en Chip queda en Chip
    public int valorNumerico() {
        return this.valor;
    }

    // tarot.modifcar(Chip)
    // chip.modificar(con lo que deba)

}
