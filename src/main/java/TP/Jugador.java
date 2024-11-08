package TP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private int puntaje;
    private List<Carta> cartas;

    public Jugador(Mano mano) {
        this.puntaje = 0;
        this.cartas = new ArrayList<>();

    }

    public void seleccionarCartas() {
    }

    public void jugarMano() {
    }

    public void agregarCartas(List<Carta> cartasNuevas) {
        cartas.addAll(cartasNuevas);
    }

    private void asignarPuntaje(int puntajeEntrante) {
        puntaje += puntajeEntrante;
    }

}
