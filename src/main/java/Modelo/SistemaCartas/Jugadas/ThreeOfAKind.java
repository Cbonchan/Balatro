package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.List;
import java.util.ArrayList;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaPuntaje.Puntaje;
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
    public  boolean esJugadaValida(@NotNull List<Poker> cartaPokers){
        if (cartaPokers.size() < 3){ return false; }

        List<Figura> figurasConThreeOfAKind = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            Poker cartaActual = cartaPokers.get(i);

            for (int j = i + 1; j < cartaPokers.size(); j++) {

                if (cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartaVecesEncontrada++;
                }
            }

            if (cartaVecesEncontrada == 2){
                figurasConThreeOfAKind.add(cartaActual.getFigura());
                break;
            }
        }
        return figurasConThreeOfAKind.size() == 1;
    }

    @Override
    public  List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers){
        List<Poker> cartasTresIguales = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            Poker cartaActual = cartaPokers.get(i);
            int cuenta = 0;

            for (int j = 0; j < cartaPokers.size(); j++) {
                if (cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartasTresIguales.add(cartaPokers.get(j));
                    cuenta++;
                }
                if (cuenta == 3) break;
            }

            if (cuenta == 3) return cartasTresIguales;
        }

        return cartasTresIguales;
    }

}
