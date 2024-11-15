package Modelo.SistemaCartas.Poker;

// Importaciones
import Modelo.SistemaCartas.Poker.Palo.Palo;
import Modelo.SistemaCartas.Poker.Figura.Figura;

public class CartaPoker {
    // Atributos
    private final Palo palo;
    private final Figura figura;
    private int puntaje;
    private int multiplicador;

    // Constructor
    public CartaPoker(Palo palo, Figura figura) {
        this.palo = palo;
        this.figura = figura;
        this.multiplicador = 0;

        puntaje = figura.devolverPuntaje();
    }

    // Getters y Setters
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public Palo getPalo() {
        return this.palo;
    }

    public Figura getFigura(){
        return this.figura;
    }


    // Métodos
    public int sumarValorAgregadoMultiplicador(int multiplicadorRecibido){
        return (multiplicadorRecibido + multiplicador);
    }

    public int sumarValorAgregadoPuntuacion(int puntajeRecibido){
        return (puntajeRecibido + puntaje);
    }

    public boolean esFiguraIgualA(Figura figura){
        return (this.figura.getNombre().equals(figura.getNombre()));
    }

}
