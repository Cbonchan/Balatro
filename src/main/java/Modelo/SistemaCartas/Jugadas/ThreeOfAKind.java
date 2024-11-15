package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.Figura.*;
import Modelo.SistemaCartas.Poker.CartaPoker;

import java.util.List;
import java.util.ArrayList;

public class ThreeOfAKind extends  Jugada{

    // Atributos
    // Chips = 30 y Multiplicador = 3

    // Constructor
    public ThreeOfAKind() {super(30, 3);}

    // Métodos

    public static boolean esJugadaValida(@NotNull List< CartaPoker > cartaPokers){
        if (cartaPokers.size() < 3){
            return false;
        }
        List<Figura> figurasConThreeOfAKind = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

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

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers){
        List<CartaPoker> cartasTresIguales = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            CartaPoker cartaActual = cartaPokers.get(i);
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
