package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;


public class Pair extends Jugada {

    // Atributos
    //  Chips = 10 y Multiplicador = 2

    // Constructor
    public Pair() {
        super( new Chip(10), new Multiplicador( 2));
    }

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartas) {

        // Primera condición, no existe par con menos de 2 cartas
         if (cartas.size() < 2) {
            return false;
        }

         // Ordenar de mayor a menor
        List<Poker>cartasOrdenadas = ordenarCartas(cartas);

         // Identificar si hay un par, (Palo repetido)

        for ( int i = 0; i < cartasOrdenadas.size() - 1; i++ ) {

            // variables para mayor claridad
            Poker actual = cartas.get(i);
            Poker siguiente = cartas.get(i + 1);

            // Verificar si la carta actual no es consecutiva con la siguiente
            if (actual.tieneMismaFiguraQue(siguiente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public   List<Poker> cartasJugadas(@NotNull List<Poker> cartas){

        //Cartas involucradas en el Par
        List<Poker> cartasDelPar = new ArrayList<>();

        // Ordenar de mayor a menor
        cartas = ordenarCartas(cartas);

        // Busco esas cartas que forman el par
        for (int i = 0; i < cartas.size() - 1; i++) {
            Poker cartaActual = cartas.get(i);
            Poker cartaSiguiente = cartas.get(i+1);

            if (cartaActual.tieneMismaFiguraQue(cartaSiguiente)) {
                cartasDelPar.add(cartaActual);
                cartasDelPar.add(cartaSiguiente);
                return  cartasDelPar;
            }
        }

        //! Mejorar esto
        return  cartasDelPar;
    }
}
