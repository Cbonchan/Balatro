package Modelo.SistemaCartas.Jugadas;

// Importaciones
import  Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Poker;
import  Modelo.SistemaPuntaje.*;

import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.Chip;
import org.jetbrains.annotations.NotNull;

public class Flush extends Jugada{

    // Atributos
    //  Chips = 35 y Multiplificador  = 4

    // Constructor
    public Flush() {
        super( new Chip(35), new Multiplicador( 4));
    }

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers) {
        // Verificamos que todas las cartas tengan el mismo palo
        if (cartaPokers.size() != 5){ return false; }

        Palo palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (Poker carta : cartaPokers) {
            if (!(carta.getPalo().esPalo(palo.getNombre()))) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }
        return true; // Si todas las cartas tienen el mismo palo, es un Flush
    }

    @Override
    public List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }
}
