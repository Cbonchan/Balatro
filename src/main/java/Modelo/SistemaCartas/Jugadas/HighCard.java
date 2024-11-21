package Modelo.SistemaCartas.Jugadas;

import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public class HighCard  extends  Jugada{

    // Atributos
    //  Chips = 5 y Multiplicador = 1

    // Constructor
    public HighCard() {
        super( new Chip(5), new Multiplicador( 1));
    }

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartas) {
        return !cartas.isEmpty();
    }

    @Override
    public   List<Poker> cartasJugadas(@NotNull List<Poker> cartas){
        List<Poker> cartasOrdenadas = ordenarCartas(cartas);
        Poker cartaAlta = cartasOrdenadas.get(0);
        return List.of(cartaAlta);
    }

}
