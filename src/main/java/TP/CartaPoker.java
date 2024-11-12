package TP;

public class CartaPoker {
    private final Palo palo;
    private final Figura figura;
    private int puntaje;
    private int multiplicador;

    public CartaPoker(Palo palo, Figura figura) {
        this.palo = palo;
        this.figura = figura;

        puntaje = figura.devolverPuntaje();
        this.multiplicador = 1;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int sumarValorAgregadoPuntuacion(int puntajeRecibido){
        return (puntajeRecibido + puntaje);
    }

    public boolean esFiguraIgualA(Figura figura){
        return this.figura.equals(figura);
    }

    // :'v
    public Figura getFigura(){
        return this.figura;
    }

}
