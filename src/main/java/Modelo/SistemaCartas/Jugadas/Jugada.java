package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Jugada {

    // Atributos
    private int chips;
    private int multiplicador;

    // Constructor
    public Jugada(int puntaje, int multiplicador) {
        this.chips = puntaje;
        this.multiplicador = multiplicador;
    }

    // Métodos
    public abstract List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers);

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

// Multip[lificador  = 2 y Chips = 20



