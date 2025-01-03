package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.List;
import org.jetbrains.annotations.NotNull;


public class StraightFlush extends  Jugada{

    // Atributos
    // Chips = 100 y Multiplicador = 8
    Flush flush = new Flush();
    Straight straight = new Straight();

    // Constructor
    public StraightFlush() {
        super("escalera de color", new Chip(100), new Multiplicador( 8));
    }

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas) {
        return ( flush.esJugadaValida(cartas) && straight.esJugadaValida(cartas) );
    }

    @Override
    public  List<Carta> cartasJugadas(@NotNull List<Carta> cartas){
        return  ordenarCartas(cartas);
    }

}

