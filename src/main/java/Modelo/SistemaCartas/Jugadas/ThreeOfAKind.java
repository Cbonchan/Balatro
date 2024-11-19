package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class ThreeOfAKind extends  Jugada{

    // Atributos
    // Chips = 30 y Multiplicador = 3

    // Constructor
    public ThreeOfAKind() {
        super( new Chip(30), new Multiplicador( 3));
    }

    // Métodos
    @Override
    public  boolean esJugadaValida(@NotNull List<Poker> cartas){

        // Primera condición, no existe Trio con menos de 3 cartas
        if (cartas.size() < 3) {
            return false;
        }

        // Ordenar de mayor a menor
        List<Poker> cartasOrdenadas = ordenarCartas(cartas);

        // Identificar si hay un trio (tres cartas con la misma figura)
        for (int i = 0; i < cartasOrdenadas.size() - 2; i++) {
            Poker actual = cartasOrdenadas.get(i);
            Poker siguiente = cartasOrdenadas.get(i + 1);
            Poker subsiguiente = cartasOrdenadas.get(i + 2);

            if (actual.tieneMismaFiguraQue(siguiente) && siguiente.tieneMismaFiguraQue(subsiguiente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public   List<Poker> cartasJugadas(@NotNull List<Poker> cartas){

        List<Poker> cartasDelTrio = new ArrayList<>();

        // Primera condición, no existe Trio con menos de 3 cartas
        if (cartas.size() < 3) {
            return cartasDelTrio;
        }

        // Ordenar de mayor a menor
        List<Poker> cartasOrdenadas = ordenarCartas(cartas);

        // Identificar las cartas que forman el trio
        for (int i = 0; i < cartasOrdenadas.size() - 2; i++) {
            Poker actual = cartasOrdenadas.get(i);
            Poker siguiente = cartasOrdenadas.get(i + 1);
            Poker subsiguiente = cartasOrdenadas.get(i + 2);

            if (actual.tieneMismaFiguraQue(siguiente) && siguiente.tieneMismaFiguraQue(subsiguiente)) {
                cartasDelTrio.add(actual);
                cartasDelTrio.add(siguiente);
                cartasDelTrio.add(subsiguiente);
                return cartasDelTrio;
            }
        }
        return cartasDelTrio;
    }

}
