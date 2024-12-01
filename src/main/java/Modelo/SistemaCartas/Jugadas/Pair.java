package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Carta;

import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;


public class Pair extends Jugada {

    // Atributos
    //  Chips = 10 y Multiplicador = 2

    // Constructor
    public Pair() {
        super( "Par",new Chip(10), new Multiplicador( 2));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("par");
    }

    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas) {

        // Primera condición, no existe par con menos de 2 cartas
         if (cartas.size() < 2) {
            return false;
        }

         // Ordenar de mayor a menor
        List<Carta>cartasOrdenadas = ordenarCartas(cartas);

         // Identificar si hay un par, (Palo repetido)

        for ( int i = 0; i < cartasOrdenadas.size() - 1; i++ ) {

            // variables para mayor claridad
            Carta actual = cartas.get(i);
            Carta siguiente = cartas.get(i + 1);

            // Verificar si la carta actual no es consecutiva con la siguiente
            if (actual.tieneMismaFiguraQue(siguiente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public   List<Carta> cartasJugadas(@NotNull List<Carta> cartas){

        //Cartas involucradas en el Par
        List<Carta> cartasDelPar = new ArrayList<>();

        // Ordenar de mayor a menor
        cartas = ordenarCartas(cartas);

        // Busco esas cartas que forman el par
        for (int i = 0; i < cartas.size() - 1; i++) {
            Carta cartaActual = cartas.get(i);
            Carta cartaSiguiente = cartas.get(i+1);

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
