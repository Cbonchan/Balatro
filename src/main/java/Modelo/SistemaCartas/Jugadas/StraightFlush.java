package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class StraightFlush extends  Jugada{

    // Atributos
    // Chips = 100 y Multiplicador = 8


    // Constructor
    public StraightFlush() {super(100, 8);}

    // Métodos
    public List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}

