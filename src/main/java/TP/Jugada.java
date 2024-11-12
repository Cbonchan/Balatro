package TP;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

abstract class Jugada {
    private int puntaje;
    private int multiplicador;

    public Jugada(int puntaje, int multiplicador) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
    }

}
//las jugadas agregan al multiplicador y agregan
//sus puntos al marcador cuando se realizan
//NO EXISTE MANO QUE NO LLEVE A UNA JUGADA

class Pair extends Jugada {
    //mult=2 puntaje=10
    public Pair() {
        super(10, 2);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
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
}

class TwoPair extends Jugada {
    //mult=2 puntaje=20

    public TwoPair() {
        super(20, 2);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
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

}

class ThreeOfAKind extends Jugada {
    //mult=3 puntaje=30

    public ThreeOfAKind() {
        super(30, 3);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){

        List <Figura> figurasConThreeOfAKind = new ArrayList<>();

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
}

class HighCard extends Jugada {
    public HighCard() {
        super(5, 1);
    }

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers){
        return !cartaPokers.isEmpty();
    }
//NOTA: Implementacion DE LA JUGADA, esto devuelve de una lista
// las cartas que son aptas para la jugada
    public static CartaPoker obtenerHighCard(List<CartaPoker> cartaPokers){
        Collections.sort(cartaPokers, (c1, c2) -> Integer.compare(c2.getFigura().devolverPuntaje(), c1.getFigura().devolverPuntaje()));
        return cartaPokers.get(0);
    }
}

class Straight extends Jugada {
    //mult=4 puntaje=30

    public Straight() {
        super(30, 4);
    }

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers) {
        // Ordenamos la lista en orden ascendente según la figura
        Collections.sort(cartaPokers, (c1, c2) -> Integer.compare(c1.getFigura().devolverPuntaje(), c2.getFigura().devolverPuntaje()));

        for (int i = 0; i < cartaPokers.size() - 1; i++) {
            int valorActual = cartaPokers.get(i).getFigura().devolverPuntaje();
            int valorSiguiente = cartaPokers.get(i + 1).getFigura().devolverPuntaje();

            // Verificamos que cada carta sea un punto más que la anterior
            if (valorSiguiente != valorActual + 1) {
                return false;
            }
        }
        return true;
    }

}

class Flush extends Jugada {
    //mult=4 puntaje=35

    public Flush() {
        super(35, 4);
    }
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
        // Verificamos que todas las cartas tengan el mismo palo
        Palo palo = cartaPokers.get(0).getPalo(); // Tomamos el palo de la primera carta

        for (CartaPoker carta : cartaPokers) {
            if (!carta.getPalo().equals(palo)) {
                return false; // Si alguna carta tiene un palo diferente, no es un Flush
            }
        }

        return true; // Si todas las cartas tienen el mismo palo, es un Flush
    }
}

class FullHouse extends Jugada {
    //mult=4 puntaje=40

    public FullHouse() {
        super(40, 4);
    }
    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers) {
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
}

class FourOfAKind extends Jugada {
    //mult=7 puntaje=60

    public FourOfAKind() {
        super(60, 7);
    }

    public static boolean esJugadaValida(@NotNull List<CartaPoker> cartaPokers){
        List<Figura> figurasConFourOfAKind = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

            for (int j = i + 1; j < cartaPokers.size(); j++) {
                if(cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())){
                    cartaVecesEncontrada++;
                }
            }

            if (cartaVecesEncontrada ==3){
                figurasConFourOfAKind.add(cartaActual.getFigura());
                break;
            }
        }
        return figurasConFourOfAKind.size() == 1;
    }
}

class StraightFlush extends Jugada {
    //mult=8 puntaje=100

    public StraightFlush() {
        super(100, 8);
    }
}
