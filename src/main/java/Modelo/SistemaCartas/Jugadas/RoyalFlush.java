package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;
import java.util.ArrayList;

public class RoyalFlush extends  Jugada {

    // Atributos
    // Chips = 100 y Multiplicador = 8

    // Constructor
    public RoyalFlush() {
        super(100, 8);
    }


    //  Métodos
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        if (cartaPokers.size() != 5){return false;}

        // Verificamos que todas las cartas tengan el mismo palo
        Palo palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (CartaPoker carta : cartaPokers) {
            if (!carta.getPalo().equals(palo)) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }

        List<Figura> figurasEsperados = List.of(
                new As(), new Rey(), new Reina(), new Jota(), new Diez());

        int cartaVecesEncontrada = 0;

        for (int i = 0; i < cartaPokers.size(); i++){
            CartaPoker cartaActual = cartaPokers.get(i);
            for (int j = 0; j < figurasEsperados.size(); j++) {
                if ( cartaActual.esFiguraIgualA(figurasEsperados.get(j)) ){
                    cartaVecesEncontrada++;
                }
            }
        }
        return  cartaVecesEncontrada == 5;
    }

    public List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}