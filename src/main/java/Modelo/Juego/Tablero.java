package Modelo.Juego;

// Importaciones
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.SistemaCartas.Tarot.*;

import java.util.List;

public class Tablero {
    // Atribnutos
    private List<Tarot> tarots;
    private Jugador jugador;
    //private List<jockers> jockers;

    // Constructor
    public int jugarMano(Mano mano) {
        return mano.calcularPuntaje();
    }

    //Métodos
}