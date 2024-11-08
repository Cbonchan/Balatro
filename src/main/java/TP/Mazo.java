package TP;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;


public class Mazo {

    private final ArrayList<Carta> cartas;
    private int cantidadCartas;

    public Mazo() {
        this.cantidadCartas = 52;
        cartas = new ArrayList<Carta>();

        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Palo[] palos = {new Corazones(), new Diamantes(), new Treboles(), new Picas()};

        for (Palo palo : palos) {
            for (String valor : valores ) {
                cartas.add(new Carta(palo, Integer.parseInt(valor)));
            }
        }
    }

    public boolean mazoCompleto() {
        return cantidadCartas == 52;
    }

    public void repartirCartas(Jugador jugador) {
        List<Carta> cartasParaMandar = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            cartasParaMandar.add(cartaAleatoria());
        }
        jugador.agregarCartas(cartasParaMandar);
    }

    private Carta cartaAleatoria() {
        int indice = (int) (Math.random() * cantidadCartas);
        Carta carta = cartas.get(indice);
        cartas.remove(indice);
        cantidadCartas--;
        return carta;
    }
}
