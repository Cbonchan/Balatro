package Modelo.SistemaCartas.Jugadas;

import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaPuntaje.*;

import java.util.Collections;
import java.util.List;

public class HighCard  extends  Jugada{

    // Atributos
    //  Chips = 5 y Multiplicador = 1

    // Constructor
    public HighCard() {
        super( new Chip(5), new Multiplicador( 1));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("carta alta");
    }

    @Override
    public boolean esJugadaValida(List<Poker> cartaPokers) {
        return !cartaPokers.isEmpty();
    }

    @Override
    public  List<Poker> cartasJugada(List<Poker> cartaPokers){
        Collections.sort( cartaPokers, (c1, c2) -> Integer.compare(c2.getFigura().devolverPuntaje(), c1.getFigura().devolverPuntaje()) );
        return List.of( cartaPokers.get(0) );
    }
}
