package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Carta;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Straight  extends  Jugada{

    // Atributos
    // Chips = 30 Multiplicador = 4

    // Constructor
    public Straight() {
        super("Escalera", new Chip(30), new Multiplicador( 4));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("escalera");
    }

    @Override
    public  boolean esJugadaValida(@NotNull List<Carta> cartas) {

        // Primera condición, no existe escalera con menos de 5 cartas
        if (cartas.size() != 5){
            return false;
        }

        //  Ordenamos de mayor a menor

        List<Carta>cartasOrdenadas = ordenarCartas(cartas);

        //  Verificamos que las cartas sean consecutivas
        for ( int i = 0; i < cartasOrdenadas.size() - 1; i++ ) {
            // variables para mayor claridad
            Carta actual = cartasOrdenadas.get(i);
            Carta siguiente = cartasOrdenadas.get(i + 1);

            // Verificar si la carta actual no es consecutiva con la siguiente
            if (!actual.laCartaSiguienteEs(siguiente)) {
                return false;
            }
        }
        return true; // Todas las cartas son consecutivas
    }

    @Override
    public  List<Carta> cartasJugadas(@NotNull List<Carta> cartas){

        return  ordenarCartas(cartas);
    }

}
