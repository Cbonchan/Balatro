package TP;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<CartaPoker> cartaPokers;
    private Jugada jugada;

    public Mano() {
        this.cartaPokers = new ArrayList<>();
    }

    public void agregarCarta(CartaPoker cartaPoker) {
        if (cartaPokers.size() < 5) {
            cartaPokers.add(cartaPoker);
        } else {
            throw new IllegalStateException("La mano ya tiene 5 cartas.");
        }
        // Se actualiza la jugada en cada agregado de carta
        jugada = Manejador.determinarJugada(cartaPokers);
    }

    public void vaciarMano() {
        cartaPokers.clear();
    }
/*
    // El multiplicador y puntaje ahora lo tendría Jugada, los metodos de abajo no tienen que manejarse aca

    public void aumentarMultiplicador(int multiplicador) {
        this.multiplicador += multiplicador;
    }
*/
    public int calcularPuntaje() {
        List<CartaPoker> cartaPokers1 = jugada.cartasJugada(cartaPokers);
        Puntuador puntuador = new Puntuador(this.jugada); //TODO: se puede mandar directamente cartaPokers y no hacer una copia
        return  puntuador.calularPuntaje(cartaPokers1); //! se pasan las cartas teniendo ya las cartas

        /*
        CartaPoker cartaPoker = cartaPokers1.get(0);
        int puntos = 0;
        int multiplicador = 0;
        for (CartaPoker cartaPoker1: cartaPokers1){
            puntos += cartaPoker1.sumarValorAgregadoPuntuacion(jugada.getPuntaje())
        }


        for (int i = 1; i < cartaPokers1.size(); i++) {
            puntos = cartaPoker.sumarPuntosCartaPokerCon(cartaPokers1.get(i));
            multiplicador = cartaPoker.sumarMultiplicadorCartaPokerCon(cartaPokers1.get(i));
        }
        return (puntos ) * (multiplicador);
       */
      /*
        for (CartaPoker cartaPoker : cartaPokers1) {
            puntaje = cartaPoker.sumarValorAgregadoPuntuacion(puntaje);
        }
        return (puntaje *= multiplicador);
    */
    }


}
