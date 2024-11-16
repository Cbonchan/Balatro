package Modelo.Juego;

// Importaciones
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.SistemaCartas.Tarot.*;

import java.util.List;

public class Tablero {

    // Atributos
    //private List<Jocker> jockers;
    private List<Tarot> tarots;
    private Jugador jugador;

    // Constructor
    public int jugarMano(Mano mano) {
        return mano.calcularPuntaje();
    }

    //Métodos
}