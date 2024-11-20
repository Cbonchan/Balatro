package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.*;

import java.util.List;
import org.jetbrains.annotations.NotNull;


public class RoyalFlush extends  Jugada {

    // Atributos
    // Chips = 100 y Multiplicador = 8
    Flush flush = new Flush();

    // Constructor
    public RoyalFlush() {
        super( new Chip(100), new Multiplicador( 8));
    }


    //  Métodos
    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartas) {

       // Verificamos que haya 5 cartas
        if (cartas.size() != 5){
            return false;
        }

        // Verificar que sea un Flush (mismo Palo)
        if (!flush.esJugadaValida(cartas) ){
            return false;
        }

        cartas = ordenarCartas(cartas);
        // Escalera Real
        List<Figura> figurasEsperadas = List.of(
                new As(), new Rey(), new Reina(), new Jota(), new Diez());


        for (int i = 0; i < cartas.size(); i++) {

            if ( !cartas.get(i).esFiguraIgualA(figurasEsperadas.get(i)) ){
                return false;
            }
        }
        return  true;
    }

    @Override
    public   List<Poker> cartasJugadas(@NotNull List<Poker> cartas){
        return ordenarCartas(cartas);
    }
}