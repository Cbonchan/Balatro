package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.Figura;

import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.*;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.NotNull;

public class FullHouse extends  Jugada{

    //Atributos
    //  Chips = 40 y Multiplicador = 4

    // Constructor
    public FullHouse() {
        super( new Chip(40), new Multiplicador( 4));
    }

    // Métodos

    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers) {
        if ( cartaPokers.size() != 5 ){ return false; }

        List<Figura> figurasConPair = new ArrayList<>();
        List<Figura> figurasConThreeOfAKind = new ArrayList<>();

        //! No esta bueno crear variables dentro del ciclo
        for ( int i = 0;  i < cartaPokers.size();  i++ ) {
            int cartaVecesEncontrada = 0;
            Poker cartaActual = cartaPokers.get(i);

            // Contar cuántas veces aparece esta figura en el resto de la lista
            for ( int j = 0;  j < cartaPokers.size();  j++ ) {
                if ( i != j  &&  cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura()) ) {
                    cartaVecesEncontrada++;
                }
            }

            // Si encontramos exactamente 2 coincidencias, es un "Three of a Kind"
            if ( cartaVecesEncontrada == 2  &&  !figurasConThreeOfAKind.contains(cartaActual.getFigura()) ) {
                figurasConThreeOfAKind.add(cartaActual.getFigura());
            }
            // Si encontramos exactamente 1 coincidencia, es un "Pair"
            else if ( cartaVecesEncontrada == 1  &&  !figurasConPair.contains(cartaActual.getFigura()) ) {
                figurasConPair.add(cartaActual.getFigura());
            }
        }

        // Verificamos si tenemos un "Three of a Kind" y un "Pair" de diferentes figuras
        return ( figurasConThreeOfAKind.size() == 1  &&  figurasConPair.size() == 1);
    }

    @Override
    public  List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers) {
        return new ArrayList<>( cartaPokers );
    }

}