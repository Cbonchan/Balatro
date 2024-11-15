package Modelo.SistemaCartas.Jugadas;

import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.Collections;
import java.util.List;

public class HighCard  extends  Jugada{

    // Atributos
    //  Chips = 5 y Multiplicador = 1

    // Constructor
    public HighCard() {
        super(5, 1);
    }

    // Métodos
    public static boolean esJugadaValida(List<CartaPoker> cartaPokers){
        return !cartaPokers.isEmpty();
    }

    public  List<CartaPoker> cartasJugada(List<CartaPoker> cartaPokers){
        Collections.sort(cartaPokers, (c1, c2) -> Integer.compare(c2.getFigura().devolverPuntaje(), c1.getFigura().devolverPuntaje()));
        return List.of(cartaPokers.get(0));
    }
}
