package Modelo.SistemaPuntaje;

public class Multiplicador {

    private int valor;

    // Constructor
    public Multiplicador(int valor) {
        this.valor = valor;
    }

    // Métodos
    public Multiplicador sumar(Multiplicador otroMultiplicador) {
        return new Multiplicador(this.valor * otroMultiplicador.valorNumerico());
    }

    public Multiplicador sumarDeVerdad(Multiplicador otroMultiplicador) {
        return new Multiplicador(this.valor + otroMultiplicador.valorNumerico());
    }

    public int multiplicarCon(Chip chip) {
        return  (chip.multiplicarCon(this.valor));
    }

    // Solo usar en Puntajes, si se usa afuera, se rompe pilar
    // Recordar: Lo que pasa en Multiplicador queda en Multiplicador
    public int valorNumerico() {
        return this.valor;
    }

    public void incrementar(int incremento){
        valor += incremento;
    }
}
