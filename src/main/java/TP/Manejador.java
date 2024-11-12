package TP;

import java.util.List;

public class Manejador {
    public static Jugada determinarJugada(List<CartaPoker> cartaPokers){
        if (Pair.esJugadaValida(cartaPokers)){
            return new Pair();
        }
        if (TwoPair.esJugadaValida(cartaPokers)){
            return new TwoPair();
        }
        if(ThreeOfAKind.esJugadaValida(cartaPokers)){
            return new ThreeOfAKind();
        }
        if(Straight.esJugadaValida(cartaPokers)){
            return new Straight();
        }
        if (Flush.esJugadaValida(cartaPokers)){
            return new Flush();
        }
        if (FullHouse.esJugadaValida(cartaPokers)){
            return new FullHouse();
        }
        if (FourOfAKind.esJugadaValida(cartaPokers)){
            return new FourOfAKind();
        }
        if(StraightFlush.esJugadaValida(cartaPokers)){
            return new StraightFlush();
        }
        else{
            return new HighCard();
        }

    }
}
