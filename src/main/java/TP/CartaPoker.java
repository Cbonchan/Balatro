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
        this.multiplicador = 0;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public void setMultiplicador(int multiplicador) {

        this.multiplicador = multiplicador;
    }
    //------------------------------------------------------------------------
    public int sumarValorAgregadoMultiplicador(int multiplicadorRecibido){

        return (multiplicadorRecibido + multiplicador);
    }
    //-----------------------------------------------------------------------
    public int sumarValorAgregadoPuntuacion(int puntajeRecibido){

        return (puntajeRecibido + puntaje);
    }

    public boolean esFiguraIgualA(Figura figura){

        return this.figura.getNombre().equals(figura.getNombre());
    }

    // :'v
    public Figura getFigura(){
        return this.figura;
    }

    public String getPalo() {
        return palo.getNombre();
    }
}
