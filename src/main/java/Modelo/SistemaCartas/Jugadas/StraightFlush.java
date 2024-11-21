package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.NotNull;

public class StraightFlush extends  Jugada{

    // Atributos
    // Chips = 100 y Multiplicador = 8
    Flush flush = new Flush();
    Straight straight = new Straight();

    // Constructor
    public StraightFlush() {
        super( new Chip(100), new Multiplicador( 8));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("escalera de color");
    }


    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers) {
        return ( flush.esJugadaValida(cartaPokers) && straight.esJugadaValida(cartaPokers) );
    }

    @Override
    public List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}

