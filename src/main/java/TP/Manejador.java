package TP;

import java.util.List;
import java.util.List;

public class Manejador {
    public static Jugada determinarJugada(List<CartaPoker> cartaPokers) {

        if (RoyalFLush.esJugadaValida(cartaPokers)){
            return new RoyalFLush();
        }
        if (FourOfAKind.esJugadaValida(cartaPokers)){
            return new FourOfAKind();
        }
        if (FullHouse.esJugadaValida(cartaPokers)){
            return new FullHouse();
        }
        if(ThreeOfAKind.esJugadaValida(cartaPokers)){
            return new ThreeOfAKind();
        }
        if (TwoPair.esJugadaValida(cartaPokers)){
            return new TwoPair();
        }
        if (Pair.esJugadaValida(cartaPokers)){
            return new Pair();
        }
        if(Straight.esJugadaValida(cartaPokers) && Flush.esJugadaValida(cartaPokers)){
            return new StraightFlush();
        }
        if(Straight.esJugadaValida(cartaPokers)){
            return new Straight();
        }
        if (Flush.esJugadaValida(cartaPokers)){
            return new Flush();
        }
        else{
            return new HighCard();
        }

    }
}
