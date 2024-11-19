package Modelo.SistemaCartas.Jugadas;

// Importaciones

import Modelo.SistemaCartas.Poker.Poker;
import Modelo.SistemaCartas.Poker.Figura.Figura;


import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.*;
import Modelo.SistemaPuntaje.Puntaje;
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
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("par");
    }

    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers) {
         if (cartaPokers.size() < 2) {
            return false;
        }
        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                Figura otraFigura = cartaPokers.get(j).getFigura();

                if (cartaPokers.get(i).esFiguraIgualA(otraFigura)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public  List <Poker> cartasJugada(@NotNull List<Poker> cartaPokers){
        List<Poker> cartasDelPar = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                if (cartaPokers.get(i).esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartasDelPar.add(cartaPokers.get(i));
                    cartasDelPar.add(cartaPokers.get(j));
                    return cartasDelPar; // Primer par encontrado
                }
            }
        }

        return cartasDelPar; // Vacío en caso de que no se haya encontrado par
    }

}
