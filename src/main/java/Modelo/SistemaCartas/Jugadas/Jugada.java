package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class Jugada {

    // Atributos
    private final int chips;
    private final int multiplicador;

    // Constructor
    public Jugada(int puntaje, int multiplicador) {
        this.chips = puntaje;
        this.multiplicador = multiplicador;
    }

    // Métodos
    // Abstractos
    public abstract List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers);

    public abstract boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers);

    // Públicos
    public int puntajeJugada() {
        return chips;
    }

    public int multiplicadorJugada() {
        return multiplicador;
    }
}

//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGADA