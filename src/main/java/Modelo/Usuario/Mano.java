package Modelo.Usuario;

// Importaciones
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

    // Públicos

    public int obtenerMultiplicador(){
        return (jugada.obtenerMultiplicador());
    }

    public void sumarMultiplicador(int incremento){
        jugada.sumarMultiplicador(incremento);
    }

    public void multiplicarMultiplicador(int incremento){
        jugada.multiplicarMultiplicador(incremento);
    }

    public int obtenerChips(){
        return (jugada.obtenerChips());
    }

    public void aumentarChips(int puntaje, int multiplicador){
        jugada.aumentarChips(puntaje, multiplicador);
    }
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
//post:aumenta el valor de los chips y mult de una jugada pasada por string
    public void mejorarJugada(int puntos, int multiplicador, String jugada){
        for (Jugada jugadaAMejorar:jugadasPosibles){
            if (jugadaAMejorar.validarNombreJugada(jugada)) {
                jugadaAMejorar.mejorar(puntos, multiplicador);
            }
        }
    }
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

    public boolean validarNombreMano(String manoAValidar){
        return this.jugada.validarNombreJugada(manoAValidar);
    }

    /*
    // El multiplicador y puntaje ahora lo tendría Jugada, los metodos de abajo no tienen que manejarse aca

    public void aumentarMultiplicador(int multiplicador) {
        this.multiplicador += multiplicador;
    }
*/

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

    public List<Carta> cartasAcumuladas(List<Carta> lista){
        lista.addAll(cartas);
        return lista;
    }
}
