package TP;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<CartaPoker> cartaPokers;
    private int multiplicador;
    private int puntaje;

    public Mano() {
        this.cartaPokers = new ArrayList<>();
        this.multiplicador = 0;
        this.puntaje = 0;
    }

    public void agregarCarta(CartaPoker cartaPoker) {
        if (cartaPokers.size() < 5) {
            cartaPokers.add(cartaPoker);
        } else {
            throw new IllegalStateException("La mano ya tiene 5 cartas.");
        }
    }

    public void vaciarMano() {
        cartaPokers.clear();
    }

}
