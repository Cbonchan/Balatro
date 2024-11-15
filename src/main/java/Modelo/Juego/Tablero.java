package Modelo.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Tarot;

import java.util.List;

public class Tablero {
    private List<Tarot> tarots;
    private Jugador jugador;
    //private List<jockers> jockers;

    public int jugarMano(Mano mano) {
        return mano.calcularPuntaje();
    }


}