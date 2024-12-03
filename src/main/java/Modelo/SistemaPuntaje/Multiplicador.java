package Modelo.SistemaPuntaje;

public class Multiplicador {

    private int valor;

    // Constructor
    public Multiplicador(int valor) {
        this.valor = valor;
    }

    // Métodos
    public int multiplicarCon(Chip chip) {
        return  (chip.multiplicarCon(this.valor));
    }

    // Post: Suma el valor de los multiplicadores
    public Multiplicador sumarMultiplicador(Multiplicador otroMultiplicador) {
        return new Multiplicador(this.valor + otroMultiplicador.valorNumerico());
    }

    // Post: Multiplica el valor de los multiplicadores
    public Multiplicador multiplicarCon(Multiplicador otroMultiplicador) {
        return new Multiplicador(this.valor * otroMultiplicador.valorNumerico());
    }

    // Post: Cambia el multiplicador por otro
    public void cambiarMultiplicador(Multiplicador otroMultiplicador) {
        this.valor = otroMultiplicador.valorNumerico();
    }

    // Solo usar en Multiplicador, si se usa afuera, se rompe pilar
    // Recordar: Lo que pasa en Multiplicador queda en Multiplicador
    public int valorNumerico() {
        return this.valor;
    }


}
