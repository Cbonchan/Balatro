package Modelo.SistemaCartas.Jugadas;

// Importaciones
import  Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Flush extends Jugada{

    // Atributos
    //  Chips = 35 y Multip[lificador  = 4

    // Constructor
    public Flush() {super(35, 4);}

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        // Verificamos que todas las cartas tengan el mismo palo
        if (cartaPokers.size() != 5){ return false; }

        Palo palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (CartaPoker carta : cartaPokers) {
            if (!(carta.getPalo().esPalo(palo.getNombre()))) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }
        return true; // Si todas las cartas tienen el mismo palo, es un Flush
    }

    @Override
    public List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }
}
