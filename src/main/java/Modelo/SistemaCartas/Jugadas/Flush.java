package Modelo.SistemaCartas.Jugadas;

// Importaciones
import  Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;

import Modelo.SistemaPuntaje.Chip;
import org.jetbrains.annotations.NotNull;

public class Flush extends Jugada{

    // Atributos
    //  Chips = 35 y Multiplicador = 4

    // Constructor
    public Flush() {
        super( new Chip(35), new Multiplicador( 4));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("color");
    }

    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartas) {

        // No hay color con menos de 5 cartas
        if (cartas.size() != 5){
            return false;
        }

        // Ordenar la lista de cartas
        List<Poker> cartasOrdenadas = ordenarCartas(cartas);
        Poker actual = cartasOrdenadas.get(0);

        for (int i = 0; i < cartasOrdenadas.size() - 1;  i++) {
            // Para mayo visualización
            Poker siguiente = cartasOrdenadas.get(i + 1);

            if ( !actual.laCartaSiguienteMismoPalo(siguiente) ){
                return false;
            }
        }
        return true;
    }

    @Override
    public   List<Poker> cartasJugadas(@NotNull List<Poker> cartas){
        return ordenarCartas(cartas);
    }

}
