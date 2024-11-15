package Modelo.SistemaCartas.Jugadas;

// Importaciones

import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.ArrayList;
import java.util.List;

public class TwoPair extends  Jugada {

    // Atributos
    // Chips = 20 y Multiplicador = 2

    // Constructores
    public TwoPair() {
        super(20, 2);
    }

    // Métodos
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
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

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers){
        List<CartaPoker> cartasDeDosPares = new ArrayList<>();
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
