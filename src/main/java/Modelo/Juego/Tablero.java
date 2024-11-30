package Modelo.Juego;

// Importaciones
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.Usuario.Jugador;
import Modelo.Usuario.Mano;
import Modelo.Usuario.PilaDescarte;
import Modelo.SistemaCartas.Activables.Joker.*;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    // Atributos
    private List<Activable> jokers;
    private List<Tarot> tarots;
    //Experimetal
    private Tarot tarotAJugar;
    private Jugador jugador;
    private PilaDescarte pilaDescarte;

    // Constructor

    public Tablero(Jugador jugador) {
        this.pilaDescarte = new PilaDescarte();
        this.jugador = jugador;
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
    }


    //Métodos

    public void agregarJoker(Joker joker) {
        jokers.add(joker);
    }

    public void destruirJoker(Joker joker) {
        jokers.remove(joker);
    }

    public void agregarTarot(Tarot tarot) {
        tarots.add(tarot);
    }

    public void destruirTarot(Tarot tarot) {
        tarots.remove(tarot);
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
    /*TODO:revisar si estas acciones pueden ser realizadas por el jugador,
       quiza haciendo que jugador conozca al tablero y pidiendole a el que
        haga estos movimientos, por ahora esto funciona*/
    public void seleccionarTarot(Tarot tarot) {
        tarotAJugar = tarot;
        tarots.remove(tarot);
    }
    public void deseleccionarTarot(Tarot tarot) {
        tarots.add(tarot);
        tarotAJugar= null;
    }
    public void jugarTarot(){
        this.tarotAJugar.activar(this.jugador);
        deseleccionarTarot(this.tarotAJugar);
        destruirTarot(this.tarotAJugar);
    }

    //Post: activa Jokers correspondientes tras realizar una jugada
    private void chequearJokersJugada(){
        for(Activable joker: this.jokers){
            joker.activar(this.jugador);
        }
    }
    //Post: activa Jokers correspondientes al realizar un descarte
    private void chequearJokersDescarte(){
        for(Activable joker: this.jokers){
            joker.activar(this.jugador);
        }
    }

}