package Modelo.Jugador;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Jugadas.*;
import Modelo.SistemaCartas.Poker.Poker;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    // Atributos
    private static final List<Jugada> jugadasPosibles = List.of(
            new FourOfAKind(), new FullHouse(), new ThreeOfAKind(),
            new TwoPair(), new Pair(), new StraightFlush(),
            new Straight(), new Flush(), new HighCard()
    );

    private Jugada jugada;
    private List<Poker> cartas;

    // Constructor
    public Mano() {
        this.cartas = new ArrayList<>();
    }

    // Métodos

    // Privados

    private Jugada determinarJugada(List<Poker> cartas) {

        for (Jugada jugada : jugadasPosibles) {

            if (jugada.esJugadaValida(cartas)) {
                return jugada;
            }
        }
        return null;
    }

    // Públicos

    public void agregarCarta(Poker cartaPoker) {
        if (cartas.size() < 5) {
            cartas.add(cartaPoker);
        } else {
            throw new IllegalStateException("La mano ya tiene 5 cartas.");
        }

        // Se actualiza la jugada en cada agregado de carta\
        jugada = determinarJugada(cartas);
    }

    public void vaciarMano() {
        cartas.clear();
    }

    /*
    // El multiplicador y puntaje ahora lo tendría Jugada, los metodos de abajo no tienen que manejarse aca

    public void aumentarMultiplicador(int multiplicador) {
        this.multiplicador += multiplicador;
    }
*/

    public int calcularPuntaje() {

        // Calcula el puntaje de la mano
        Puntaje puntajeTotal = new Puntaje( new Chip(0));

       List <Poker> cartasUtilizadas =   jugada.cartasJugada(cartas);

       // Suma de Puntaje de las cartas utilizadas
        for (Poker cartasUtilizada : cartasUtilizadas) {
            cartasUtilizada.sumarPuntajeCon(puntajeTotal);
        }

        // int
        return puntajeTotal.calcularPuntaje();
    }
}
