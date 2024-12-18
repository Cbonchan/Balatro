package Modelo.Usuario;

// Importaciones
import Modelo.SistemaPuntaje.*;
import Modelo.SistemaCartas.Jugadas.*;
import Modelo.SistemaCartas.Cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    // Atributos
    private final List<Jugada> jugadasPosibles = List.of(
            new RoyalFlush(),
            new FourOfAKind(), new FullHouse(), new ThreeOfAKind(),
            new TwoPair(), new Pair(), new StraightFlush(),
            new Straight(), new Flush(), new HighCard()
    );

   // private  int puntos;
    private Jugada jugada;
    private List<Carta> cartas;
    private Puntaje puntajeTotal;

    // Constructor
    public Mano() {
        this.cartas = new ArrayList<>();
        this.puntajeTotal = new Puntaje( new Chip(0));

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

    public void reiniciarPuntaje(){
        this.puntajeTotal = new Puntaje( new Chip(0));
    }

    //! Métodos relacionados con JavaFX

    public List<Carta> obtenerCartas(){return cartas;}

    public int obtenerChips(){
        return (jugada.obtenerChips());
    }

    public int obtenerMultiplicador(){
        return (jugada.obtenerMultiplicador());
    }

    public Jugada obtenerJugada(){return jugada;}


    //! MÉTODOS RELACIONADOS A CHIP:

    // Post: Aumenta el valor de los chips de la Jugada
    public void aumentarChips(Chip incremento){
        puntajeTotal.sumarChipCon(incremento);
        //jugada.aumentarChips(incremento);
    }

    // Post:cambiar el valor de chips de la primera carta seleccionada
    public void cambiarChipPor(int nuevoValorDeChip){
        Carta cartaSeleccionada=cartas.get(0);
        cartaSeleccionada.cambiarChip(nuevoValorDeChip);
    }

    //! MÉTODOS RELACIONADOS A MULTIPLICADOR:

    // Post: Suma el valor de los multiplicadores
    public void sumarMultiplicador(Multiplicador incremento){
        puntajeTotal.sumarMultiplicador(incremento);
        //jugada.sumarMultiplicador(incremento);
    }

    // Post: Multiplica el multiplicado de Jugada por el incremento
    public void multiplicarMultiplicador(Multiplicador incremento){
        puntajeTotal.multiplicarMultiplicadorPor(incremento);
        //jugada.multiplicarMultiplicador(incremento);
    }

    // Post: cambia el valor de mult de la primer carta seleccionada
    public void cambiarMultiplicadorPor(Multiplicador multiplicador){
        Carta cartaSeleccionada=cartas.get(0);
        cartaSeleccionada.cambiarMultiplicador(multiplicador);
    }

    //! MÉTODOS RELACIONADOS A TAROT:

    // Post: aumenta el valor de los chips y mult de una jugada pasada por string
    public void mejorarJugada(int incrementador, Multiplicador multiplicador, String jugadaElegida){

        for (Jugada jugadaAMejorar:jugadasPosibles){
            if (jugadaAMejorar.validarNombreJugada(jugadaElegida)) {
                jugadaAMejorar.mejorar(incrementador, multiplicador);
            }
        }
    }

    //! MÉTODOS RELACIONADOS A JOKER:

    // Post: Verifica si la jugada de un Joker corresponden a la jugada de la mano
    public boolean validarNombreMano(String manoAValidar){
        return this.jugada.validarNombreJugada(manoAValidar);
    }

    // Post: Verifica si la jugada de un Joker corresponden a la jugada de la mano
    public List<Carta> cartasAcumuladas(List<Carta> lista){
        lista.addAll(cartas);
        return lista;
    }

    // Post: Aumenta los puntos totales de la mano
    public void aumentarPuntos(int incremento){
        puntajeTotal.aumentarPuntaje(incremento,new Multiplicador(0));
    }

    //! MÉTODOS RELACIONADOS A JUGADOR

    // Post: agrega a la mano una carta pasada por parámetro
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

    // Post: Calcula el puntaje con Jokers involucrados por Jugada
    public int calcularPuntaje() {

        if (jugada == null) {
            return 0;
        }

        // Calcula el puntaje de la mano

        List <Carta> cartasUtilizadas =  jugada.cartasJugadas(cartas);

        // Suma de Puntaje de las cartas utilizadas
        for (Carta cartasUtilizada : cartasUtilizadas) {
            cartasUtilizada.sumarPuntajeCon(this.puntajeTotal);
        }

        // int
        return jugada.calcularPuntaje(puntajeTotal);
    }

}
