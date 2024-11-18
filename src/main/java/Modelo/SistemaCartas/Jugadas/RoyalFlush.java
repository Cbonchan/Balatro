package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Palo.*;
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.*;
import org.jetbrains.annotations.NotNull;

public class RoyalFlush extends  Jugada {

    // Atributos
    // Chips = 100 y Multiplicador = 8

    // Constructor
    public RoyalFlush() {
        super( new Chip(100), new Multiplicador( 8));
    }


    //  Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers) {
        if (cartaPokers.size() != 5){return false;}

        // Verificamos que todas las cartas tengan el mismo palo
        Palo palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (Poker carta : cartaPokers) {
            if (!carta.getPalo().equals(palo)) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }

        List<Figura> figurasEsperados = List.of(
                new As(), new Rey(), new Reina(), new Jota(), new Diez());

        int cartaVecesEncontrada = 0;

        //! Ver si es posible que no sea doble for
        for (int i = 0; i < cartaPokers.size(); i++){
            Poker cartaActual = cartaPokers.get(i);
            for (int j = 0; j < figurasEsperados.size(); j++) {
                if ( cartaActual.esFiguraIgualA(figurasEsperados.get(j)) ){
                    cartaVecesEncontrada++;
                }
            }
        }
        return  cartaVecesEncontrada == 5;
    }

    @Override
    public List<Poker> cartasJugada(List<Poker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}