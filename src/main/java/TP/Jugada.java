package TP;

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

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers){
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

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers){
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

    public static boolean esJugadaValida(List<CartaPoker> cartaPokers){

        List <Figura> figurasConThreeOfAKind = new ArrayList<>();

        for (int i = 0; i < cartaPokers.size(); i++) {
            int cartaVecesEncontrada = 0;
            CartaPoker cartaActual = cartaPokers.get(i);

            for (int j = i + 1; j < cartaPokers.size(); j++) {

                if (cartaActual.esFiguraIgualA(cartaPokers.get(j).getFigura())) {
                    cartaVecesEncontrada++;
                }
            }

            if (cartaVecesEncontrada == 2 && !figurasConThreeOfAKind.contains(cartaActual.getFigura())){
                figurasConThreeOfAKind.add(cartaActual.getFigura());
                break;
            }
        }



        return figurasConThreeOfAKind.size() == 1;
    }
}



//NOTA: ADAPTAR EL CODIGO PARA LAS NUEVAS CLASES
class HighCard extends Jugada {
    public HighCard() {
        super(5, 1);
    }
}

class Straight extends Jugada {
    //mult=4 puntaje=30

    public Straight() {
        super(30, 4);
    }
}

class Flush extends Jugada {
    //mult=4 puntaje=35

    public Flush() {
        super(35, 4);
    }
}

class FullHouse extends Jugada {
    //mult=4 puntaje=40

    public FullHouse() {
        super(40, 4);
    }
}

class FourOfAKind extends Jugada {
    //mult=7 puntaje=60

    public FourOfAKind() {
        super(60, 7);
    }
}

class StraightFlush extends Jugada {
    //mult=8 puntaje=100

    public StraightFlush() {
        super(100, 8);
    }
}

class RoyalFlush extends Jugada {
    //mult=8 puntaje=100

    public RoyalFlush() {
        super(100, 8);
    }
}