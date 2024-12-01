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

    private  int puntos;
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

    public Jugada obtenerJugada(){return jugada;}

    // Públicos

    // Relación con Chips
    public void aumentarChips(Chip incremento){
        jugada.aumentarChips(incremento);
    }

    //post:cambiar el valor de chips de la pprimer carta seleccionada
    public void cambiarChipPor(int nuevoValorDeChip){
        Carta cartaSeleccionada=cartas.get(0);
        cartaSeleccionada.cambiarChip(nuevoValorDeChip);
    }



    // Relación con Multiplicador

    // Arreglado

    // Post: Suma el valor de los multiplicadores
    public void sumarMultiplicador(Multiplicador incremento){
        jugada.sumarMultiplicador(incremento);
    }

    public void multiplicarMultiplicador(Multiplicador incremento){
        jugada.multiplicarMultiplicador(incremento);
    }

    // Post:cambia el valor de mult de la primer carta seleccionada
    public void cambiarMultiplicadorPor(Multiplicador multiplicador){
        Carta cartaSeleccionada=cartas.get(0);
        cartaSeleccionada.cambiarMultiplicador(multiplicador);
    }



    // Faltan :






    //! METODOS RELACIONADOS A TAROT:


    // Trabajar con class Multiplicador y Chips (hacer un new donde se llame solo chips)

    //post:aumenta el valor de los chips y mult de una jugada pasada por string
    public void mejorarJugada(int incrementador, Multiplicador multiplicador, String jugada){

        for (Jugada jugadaAMejorar:jugadasPosibles){
            if (jugadaAMejorar.validarNombreJugada(jugada)) {
                jugadaAMejorar.mejorar(incrementador, multiplicador);
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

    public  void aumentarPuntos(int incremento){
         puntos += incremento;
    }


    //! METODOS RELACIONADOS A JUGADOR

    // Post: Calcula el puntaje con Jokers involucrados por Jugada
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

    // Post: agrega a la mano una carta pasada por parametro
    public void agregarCarta(Carta cartaCarta) {
        if (cartas.size() < 5) {
            cartas.add(cartaCarta);
        } else {
            throw new IllegalStateException("La mano ya tiene 5 cartas.");
        }

        // Se actualiza la jugada en cada agregado de carta\
        jugada = determinarJugada(cartas);
    }

    // Post: vacía la lista de cartas de la mano
    public void vaciarMano() {
        cartas.clear();
        jugada = null;
    }





    // Viejo


}
