package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;

//! Esto irá en otro lado seguro
public class Manejador {

    // Atributos
    // Las jugadas serán constantes, no cambiaran == static
    private static final List<Jugada> jugadas = List.of(
            new FourOfAKind(), new FullHouse(), new ThreeOfAKind(),
            new TwoPair(), new Pair(), new StraightFlush(),
            new Straight(), new Flush(), new HighCard()
    );

    // Constructores
    public Manejador() {
    }

    // Métodos
    public Jugada determinarJugada(List<CartaPoker> cartaPokers) {
        for (Jugada jugada : jugadas) {
            if (jugada.esJugadaValida(cartaPokers)) {
                return jugada;
            }
        }
        return null;
    }
}
