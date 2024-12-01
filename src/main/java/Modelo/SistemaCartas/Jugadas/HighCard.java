package Modelo.SistemaCartas.Jugadas;

import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Carta;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public class HighCard  extends  Jugada{

    // Atributos
    //  Chips = 5 y Multiplicador = 1

    // Constructor
    public HighCard() {
        super( "Carta alta",new Chip(5), new Multiplicador( 1));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("carta alta");
    }

    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas) {
        return !cartas.isEmpty();
    }

    @Override
    public   List<Carta> cartasJugadas(@NotNull List<Carta> cartas){
        List<Carta> cartasOrdenadas = ordenarCartas(cartas);
        Carta cartaAlta = cartasOrdenadas.get(0);
        return List.of(cartaAlta);
    }

}
