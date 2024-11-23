package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Carta;

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
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("trio");
    }

    @Override
    public  boolean esJugadaValida(@NotNull List<Carta> cartas){

        // Primera condición, no existe Trio con menos de 3 cartas
        if (cartas.size() < 3) {
            return false;
        }

        // Ordenar de mayor a menor
        List<Carta> cartasOrdenadas = ordenarCartas(cartas);

        // Identificar si hay un trio (tres cartas con la misma figura)
        for (int i = 0; i < cartasOrdenadas.size() - 2; i++) {
            Carta actual = cartasOrdenadas.get(i);
            Carta siguiente = cartasOrdenadas.get(i + 1);
            Carta subsiguiente = cartasOrdenadas.get(i + 2);

            if (actual.tieneMismaFiguraQue(siguiente) && siguiente.tieneMismaFiguraQue(subsiguiente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public   List<Carta> cartasJugadas(@NotNull List<Carta> cartas){

        List<Carta> cartasDelTrio = new ArrayList<>();

        // Primera condición, no existe Trio con menos de 3 cartas
        if (cartas.size() < 3) {
            return cartasDelTrio;
        }

        // Ordenar de mayor a menor
        List<Carta> cartasOrdenadas = ordenarCartas(cartas);

        // Identificar las cartas que forman el trio
        for (int i = 0; i < cartasOrdenadas.size() - 2; i++) {
            Carta actual = cartasOrdenadas.get(i);
            Carta siguiente = cartasOrdenadas.get(i + 1);
            Carta subsiguiente = cartasOrdenadas.get(i + 2);

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
