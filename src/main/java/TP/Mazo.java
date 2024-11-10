package TP;

import java.util.ArrayList;
import java.util.List;


public class Mazo {

    private final ArrayList<CartaPoker> cartaPokers;
    private int cantidadCartas;

    public Mazo() {
        this.cantidadCartas = 52;
        cartaPokers = new ArrayList<CartaPoker>();

        Figura[] valores = {new As(), new Dos(), new Tres(), new Cuatro(), new Cinco(), new Seis(), new Siete(), new Ocho(), new Nueve(), new Diez(), new J(), new Q(), new K()};
        Palo[] palos = {new Corazones(), new Diamantes(), new Treboles(), new Picas()};

        for (Palo palo : palos) {
            for (Figura valor : valores ) {
                cartaPokers.add(new CartaPoker(palo, valor));
            }
        }
    }

    public boolean mazoCompleto() {
        return cantidadCartas == 52;
    }

    public void repartirCartas(Jugador jugador) {
        List<CartaPoker> cartasParaMandar = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            cartasParaMandar.add(cartaAleatoria());
        }
        jugador.agregarCartas(cartasParaMandar);
    }

    private CartaPoker cartaAleatoria() {
        int indice = (int) (Math.random() * cantidadCartas);
        CartaPoker cartaPoker = cartaPokers.get(indice);
        cartaPokers.remove(indice);
        cantidadCartas--;
        return cartaPoker;
    }
}
