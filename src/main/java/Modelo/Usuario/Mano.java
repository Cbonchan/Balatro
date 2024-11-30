package Modelo.Usuario;

// Importaciones
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Jugadas.*;
import Modelo.SistemaCartas.Poker.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    // Atributos
    private static final List<Jugada> jugadasPosibles = List.of(
            new RoyalFlush(),
            new FourOfAKind(), new FullHouse(), new ThreeOfAKind(),
            new TwoPair(), new Pair(), new StraightFlush(),
            new Straight(), new Flush(), new HighCard()
    );

    private Jugada jugada;
    private List<Carta> cartas;

    // Constructor
    public Mano() {
        this.cartas = new ArrayList<>();
    }

    // Métodos

    // Privados

    private Jugada determinarJugada(List<Carta> cartas) {

        for (Jugada jugada : jugadasPosibles) {

            if (jugada.esJugadaValida(cartas)) {
                return jugada;
            }
        }
        return null;
    }

    // Getters

    public int obtenerChips(){
        return (jugada.obtenerChips());
    }

    public int obtenerMultiplicador(){
        return (jugada.obtenerMultiplicador());
    }

    // Públicos

    public void sumarMultiplicador(int incremento){
        jugada.sumarMultiplicador(incremento);
    }

    public void multiplicarMultiplicador(int incremento){
        jugada.multiplicarMultiplicador(incremento);
    }

    public void aumentarChips(int puntaje, int multiplicador){
        jugada.aumentarChips(puntaje, multiplicador);
    }



    //! METODOS RELACIONADOS A TAROT:

    // cambiarMult y cambiarChip deberìa recibir por parametro el indice para modificar, no decidirlo
    // dentro de la implementacion

    //post:cambia el valor de mult de la primer carta seleccionada
    public void cambiarMult(int multiplicador){
        Carta cartaSeleccionada=cartas.get(0);
        cartaSeleccionada.cambiarMult(multiplicador);
    }


    //post:cambiar el valor de chips de la pprimer carta seleccionada
    public void cambiarChip(int chips){
        Carta cartaSeleccionada=cartas.get(0);
        cartaSeleccionada.cambiarChip(chips);
    }

    // Trabajar con class Multiplicador y Chips (hacer un new donde se llame solo chips)
    //post:aumenta el valor de los chips y mult de una jugada pasada por string
    public void mejorarJugada(int puntos, int multiplicador, String jugada){
        for (Jugada jugadaAMejorar:jugadasPosibles){
            if (jugadaAMejorar.validarNombreJugada(jugada)) {
                jugadaAMejorar.mejorar(puntos, multiplicador);
            }
        }
    }



    //! METODOS RELACIONADOS A JOKER

    public boolean validarNombreMano(String manoAValidar){
        return this.jugada.validarNombreJugada(manoAValidar);
    }

    public List<Carta> cartasAcumuladas(List<Carta> lista){
        lista.addAll(cartas);
        return lista;
    }



    //! METODOS RELACIONADOS A JUGADOR

    //post: agrega a la mano una carta pasada por parametro
    public void agregarCarta(Carta cartaCarta) {
        if (cartas.size() < 5) {
            cartas.add(cartaCarta);
        } else {
            throw new IllegalStateException("La mano ya tiene 5 cartas.");
        }

        // Se actualiza la jugada en cada agregado de carta\
        jugada = determinarJugada(cartas);
    }

    //Post: vacia la lista de cartas de la mano
    public void vaciarMano() {
        cartas.clear();
        jugada = null;
    }

    public int calcularPuntaje() {

        if (jugada == null) {
            return 0;
        }

        // Calcula el puntaje de la mano
        Puntaje puntajeTotal = new Puntaje( new Chip(0));

       List <Carta> cartasUtilizadas =   jugada.cartasJugadas(cartas);

       // Suma de Puntaje de las cartas utilizadas
        for (Carta cartasUtilizada : cartasUtilizadas) {
            cartasUtilizada.sumarPuntajeCon(puntajeTotal);
        }

        // int
        return jugada.calcularPuntaje(puntajeTotal);
    }

    public int calcularPuntaje(List<Joker> jokers) {

        if (jugada == null) {
            return 0;
        }

        // Calcula el puntaje de la mano
        Puntaje puntajeTotal = new Puntaje( new Chip(0));


        List <Carta> cartasUtilizadas =   jugada.cartasJugadas(cartas);

        // Suma de Puntaje de las cartas utilizadas
        for (Carta cartasUtilizada : cartasUtilizadas) {
            cartasUtilizada.sumarPuntajeCon(puntajeTotal);
        }

        jokers.chequearJokersJugada(this.jugada, puntajeTotal);

        // int
        return jugada.calcularPuntaje(puntajeTotal);
    }
}
