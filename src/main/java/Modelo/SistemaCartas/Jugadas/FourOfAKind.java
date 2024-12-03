package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.List;
import org.jetbrains.annotations.NotNull;


public class FourOfAKind extends  Jugada {

    // Atributos
    // Chips = 60 y Multiplicador = 7
    TwoPair dosPares = new TwoPair();

    // Constructor
    public FourOfAKind() {
        super("poker", new Chip(60), new Multiplicador( 7));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("poker");
    }

    // Públicos
    @Override
    public boolean esJugadaValida(@NotNull List<Carta> cartas){

        // No existe Four of a Kind con menos de 4 cartas
        if (cartas.size() < 4) {
            return false;
        }

        // Verificar si hay Two Pair
        if (!dosPares.esJugadaValida(cartas)) {
            return false;
        }

        // Verificar que ambos pares tengan la misma figura
        List<Carta> candidatoFourOfAKind = dosPares.cartasJugadas(cartas);
        Carta primeraCarta = candidatoFourOfAKind.get(0);

        for (Carta carta : candidatoFourOfAKind) {
            if (!primeraCarta.tieneMismaFiguraQue(carta)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public   List<Carta> cartasJugadas(@NotNull List<Carta> cartas){
        return dosPares.cartasJugadas(cartas);
    }

}

