package Modelo.Juego;

// Importaciones
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.PilaDescarte;
import Modelo.SistemaCartas.Tarot.*;

import java.util.List;

public class Tablero {

    // Atributos
    //private List<Jocker> jockers;
    private List<Tarot> tarots;
    private Jugador jugador;
    private PilaDescarte pilaDescarte;

    // Constructor

    public Tablero() {
        this.pilaDescarte = new PilaDescarte();
    }


    //Métodos
    public int jugarMano(Mano mano) {
        int puntaje = mano.calcularPuntaje();
        pilaDescarte.descartarManoJugada(mano);
        return puntaje;
    }

    public void descarteMano(Mano mano) {
        pilaDescarte.descartarMano(mano);
    }

}