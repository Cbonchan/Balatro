package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.*;
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class Jugada {

    // Atributos
    protected Puntaje puntaje;

    // Constructor
    public Jugada(Chip chips, Multiplicador mult) {
        this.puntaje = new Puntaje(chips, mult);
    }

    // Métodos
    // Abstractos
    public abstract List<Poker> cartasJugada(List<Poker> cartaPokers);

    public abstract boolean esJugadaValida(@NotNull List<Poker> cartaPokers);

    // Públicos

}

//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGA