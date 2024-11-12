package TP;

public class Multiplicador {

    private float valor;

    // Constructor
    public Multiplicador(float valor) {
        this.valor = valor;
    }

    public Multiplicador sumar(Multiplicador otroMultiplicador) {
        return new Multiplicador(this.valor + otroMultiplicador.valorNumerico());
    }

    // Solo usar en Puntajes, si se usa afuera, se rompe pilar
    // Recordar: Lo que pasa en Multiplicador queda en Multiplicador
    public float valorNumerico() {
        return this.valor;
    }
}
