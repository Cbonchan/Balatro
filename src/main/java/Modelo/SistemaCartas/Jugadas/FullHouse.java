package Modelo.SistemaCartas.Jugadas;

// Importaciones
import Modelo.SistemaCartas.Poker.CartaPoker;
import Modelo.SistemaCartas.Poker.Figura.Figura;

import java.util.List;
import java.util.ArrayList;

public class FullHouse extends  Jugada{

    //Atributos
    //  Chips = 40 y Multiplicador = 4

    // Constructor
    public FullHouse() {
        super(40, 4);
    }

    // Métodos
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        if (cartaPokers.size() != 5){
            return false;
        }
        List<Figura> figurasConThreeOfAKind = new ArrayList<>();
        List<Figura> figurasConPair = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

            // Contar cuántas veces aparece esta figura en el resto de la lista
            for (int j = 0; j < cartaPokers.size(); j++) {
                if (i != j && cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartaVecesEncontrada++;
                }
            }

            // Si encontramos exactamente 2 coincidencias, es un "Three of a Kind"
            if (cartaVecesEncontrada == 2 && !figurasConThreeOfAKind.contains(cartaActual.getFigura())) {
                figurasConThreeOfAKind.add(cartaActual.getFigura());
            }
            // Si encontramos exactamente 1 coincidencia, es un "Pair"
            else if (cartaVecesEncontrada == 1 && !figurasConPair.contains(cartaActual.getFigura())) {
                figurasConPair.add(cartaActual.getFigura());
            }
        }

        // Verificamos si tenemos un "Three of a Kind" y un "Pair" de diferentes figuras
        return figurasConThreeOfAKind.size() == 1 && figurasConPair.size() == 1;
    }

    public  List<CartaPoker> cartasJugada(@NotNull List<CartaPoker> cartaPokers) {
        return new ArrayList<>(cartaPokers);
    }

}