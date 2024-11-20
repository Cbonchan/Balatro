package Modelo.Juego;

// Importaciones
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.PilaDescarte;
import Modelo.SistemaCartas.Joker.Joker;
import Modelo.SistemaCartas.Tarot.*;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    // Atributos
    private List<Joker> jokers;
    private List<Tarot> tarots;
    private Jugador jugador;
    private PilaDescarte pilaDescarte;

    // Constructor

    public Tablero(Jugador jugador) {
        this.pilaDescarte = new PilaDescarte();
        this.jugador = jugador;
        this.jokers = new ArrayList<>();

    }


    //Métodos

    public void agregarJoker(Joker joker) {
        jokers.add(joker);
        return;
    }

    public void destruirJoker(Joker joker) {
        jokers.remove(joker);
        return;
    }

    public int jugarMano(Mano mano) {
        int puntaje = mano.calcularPuntaje();
        this.chequearJokersJugada();
        pilaDescarte.descartarMano(mano);
        return puntaje;
    }

    public void descarteMano(Mano mano) {
        pilaDescarte.descartarMano(mano);
        this.chequearJokersDescarte();

    }

    private void chequearJokersJugada(){
        for(Joker joker: this.jokers){
            joker.activarPorJugada(this.jugador);
        }
    }

    private void chequearJokersDescarte(){
        for(Joker joker: this.jokers){
            joker.activarPorDescarte(this.jugador);
        }
    }

}