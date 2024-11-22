package Modelo.Jugador;

// Importaciones
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.Juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    // Atributos
    private int puntaje;
    private List<Poker> cartas;
    private Mano mano;

    // Constructor
    public Jugador(Mano mano) {
        this.puntaje = 0;
        this.cartas = new ArrayList<>();
        this.mano = mano;
    }

    // Getters
    public int getCantidadCartas() {
        return cartas.size();
    }

    public int getPuntaje(){
        return puntaje;
    }


    // Métodos

    //si se selecciona una mano pero te arrepentis, con este metodo la mano se vacia
    //solucion momentanea a tener que deseleccionar cartas una por una

    public void deshacerEleccion(){
        List<Poker> cartasAReintegrar = new ArrayList<>();
        cartasAReintegrar.addAll(mano.cartasAcumuladas(cartasAReintegrar));
        cartas.addAll(cartasAReintegrar);
        mano.vaciarMano();
    }

    public void seleccionarCarta(Poker cartaPoker){
        mano.agregarCarta(cartaPoker);
        cartas.remove(cartaPoker);
    }

    public void jugar(Tablero tablero){
        int valor = tablero.jugarMano(mano);
        this.quitarCartas(mano);
        asignarPuntaje(valor);
    }

    public void descartarMano(Tablero tablero){
        tablero.descarteMano(mano);
        this.quitarCartas(mano);
        mano.vaciarMano();
    }

    public int cartasFaltantes(){
        int actuales = cartas.size();
        return 8 - actuales;
    }

    public void quitarCartas(Mano mano){
        List<Poker> cartasARemover = new ArrayList<>();
        cartasARemover = mano.cartasAcumuladas(cartasARemover);
        cartas.removeAll(cartasARemover);
    }

    public void agregarCartas(List<Poker> cartasNuevas) {
        cartas.addAll(cartasNuevas);
    }

    private void asignarPuntaje(int puntajeEntrante) {
        puntaje += puntajeEntrante;
    }

}
