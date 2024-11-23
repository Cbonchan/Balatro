package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import org.jetbrains.annotations.NotNull;


public class FourOfAKind extends  Jugada {

    // Atributos
    // Chips = 60 y Multiplicador = 7
    TwoPair dosPares = new TwoPair();

    // Constructor
    public FourOfAKind() {
        super( new Chip(60), new Multiplicador( 7));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("poker");
    }

    // Públicos
    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartas){

        // No existe Four of a Kind con menos de 4 cartas
        if (cartas.size() < 4) {
            return false;
        }

        // Verificar si hay Two Pair
        if (!dosPares.esJugadaValida(cartas)) {
            return false;
        }

        // Verificar que ambos pares tengan la misma figura
        List<Poker> candidatoFourOfAKind = dosPares.cartasJugadas(cartas);
        Poker primeraCarta = candidatoFourOfAKind.get(0);

        for (Poker carta : candidatoFourOfAKind) {
            if (!primeraCarta.tieneMismaFiguraQue(carta)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public   List<Poker> cartasJugadas(@NotNull List<Poker> cartas){
        return dosPares.cartasJugadas(cartas);
    }

}

