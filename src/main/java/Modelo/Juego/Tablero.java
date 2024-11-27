package Modelo.Juego;

// Importaciones
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import Modelo.Usuario.PilaDescarte;
import Modelo.SistemaCartas.Activables.Joker.*;

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
            joker.activar(this.jugador);
        }
    }

    private void chequearJokersDescarte(){
        for(Joker joker: this.jokers){
            joker.activar(this.jugador);
        }
    }

}