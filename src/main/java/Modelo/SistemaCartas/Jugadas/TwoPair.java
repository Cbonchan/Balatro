package Modelo.SistemaCartas.Jugadas;

// Importaciones

import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.ArrayList;
import java.util.List;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaPuntaje.Puntaje;
import org.jetbrains.annotations.NotNull;

//! Acá debería ser como StraightFlush, que verifique que solo tenga
// 2 pares
public class TwoPair extends  Jugada {

    // Atributos
    // Chips = 20 y Multiplicador = 2


    // Constructores
    public TwoPair() {
        super( new Chip(20), new Multiplicador( 2));
    }

    // Métodos
    @Override
    public boolean validarNombreJugada(String manoAValidar){
        return manoAValidar.equals("doble par");
    }

    @Override
    public boolean esJugadaValida(@NotNull List<Poker> cartaPokers){
        if (cartaPokers.size() < 4){
            return false;
        }
        List<Figura> figurasConPares = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                Figura figuraActual = cartaPokers.get(i).getFigura();
                Figura figuraAComparar = cartaPokers.get(j).getFigura();

                if (cartaPokers.get(i).esFiguraIgualA(figuraAComparar) && !figurasConPares.contains(figuraActual)) {
                    figurasConPares.add(figuraActual);
                    break;
                }
            }
        }

        return figurasConPares.size() == 2; // Devuelve true si son dos pares distintos
    }

    @Override
    public List<Poker> cartasJugada(@NotNull List<Poker> cartaPokers){
        List<Poker> cartasDeDosPares = new ArrayList<>();
        List<Figura> figurasConPares = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            for (int j = i + 1; j < cartaPokers.size(); j++) {
                Figura figuraActual = cartaPokers.get(i).getFigura();
                if (cartaPokers.get(i).esFiguraIgualA(cartaPokers.get(j).getFigura())
                        && !figurasConPares.contains(figuraActual)) {
                    figurasConPares.add(figuraActual);
                    cartasDeDosPares.add(cartaPokers.get(i));
                    cartasDeDosPares.add(cartaPokers.get(j));
                    break;
                }
            }
        }
        return cartasDeDosPares;
    }
}
