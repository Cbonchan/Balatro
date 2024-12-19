package Modelo.SistemaCartas.Jugadas;

// Importaciones
import  Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.List;

import Modelo.SistemaPuntaje.Chip;
import org.jetbrains.annotations.NotNull;

public class Flush extends Jugada{

    // Atributos
    //  Chips = 35 y Multiplicador = 4

    // Constructor
    public Flush() {
        super("color", new Chip(35), new Multiplicador( 4));
    }

    // Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas) {

        // No hay color con menos de 5 cartas
        if (cartas.size() != 5){
            return false;
        }

        // Ordenar la lista de cartas
        List<Carta> cartasOrdenadas = ordenarCartas(cartas);
        Carta actual = cartasOrdenadas.get(0);

        for (int i = 0; i < cartasOrdenadas.size() - 1;  i++) {
            // Para mayo visualización
            Carta siguiente = cartasOrdenadas.get(i + 1);

            if ( !actual.laCartaSiguienteMismoPalo(siguiente) ){
                return false;
            }
        }
        return true;
    }

    @Override
    public   List<Carta> cartasJugadas(@NotNull List<Carta> cartas){
        return ordenarCartas(cartas);
    }

}
