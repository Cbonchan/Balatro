package TP;

public class CartaPoker {
    private final Palo palo;
    private final int valor;
    private int multiplicador;

    public CartaPoker(Palo palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        this.multiplicador = 1;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int valorAgregadoPuntuacion(int puntaje){
        return (puntaje + valor);
    }

}
