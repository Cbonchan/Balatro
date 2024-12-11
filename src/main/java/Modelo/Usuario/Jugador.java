package Modelo.Usuario;

// Importaciones

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Tarot.TarotEnCarta;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    // Atributos
    private final PilaDescarte cartasDescartadas;
    private final List<Carta> cartas;           // Cartas para elegir max 8
    private final List<Joker> jokers;           // Jokers para activar max 5
    private final List<Tarot> tarots;          // Tarots para activar max 2
    private final List<TarotEnCarta> tarotsParaCarta;
    private final Mazo mazo;
    private final Mano mano;
    private int cantidadDescartes;
    private int cantidadJugadas;
    private int puntos;

    // Constructor
    public Jugador(){
        this.cartas = new ArrayList<>();
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.tarotsParaCarta = new ArrayList<>();
        this.mano = new Mano();
        this.mazo = new Mazo();
        this.puntos = 0;
        this.cartasDescartadas = new PilaDescarte();
        this.cantidadDescartes = 0;
        this.cantidadJugadas = 0;
    }

    // Métodos relacionados con JavaFX

    public int getCantidadCartas() {
        return cartas.size();
    }

    public int getPuntos(){
        return puntos;
    }

    public int obtenerChips(){
        return (mano.obtenerChips());
    }

    public int obtenerMult(){return (mano.obtenerMultiplicador());}

    public int obtenerCantidadJugadas(){return cantidadJugadas;}

    public int obtenerCantidadDescartes(){return cantidadDescartes;}

    public List<Joker> obtenerJokers(){return jokers;}

    public List<Tarot> obtenerTarots(){return tarots;}

    public List<Carta> obtenerCartas(){return cartas;}

    public Mano obtenerMano(){return mano;}


    // Métodos

    //! MÉTODOS RELACIONADOS A MAZO:

    // Post: Rellena la mano hasta tener 8 Cartas
    public void agregarCartasFaltantes() {
        mazo.repartirCartas(cartas);
    }

    //Post: Agrega una carta del Mazo a mi lista de cartas
    public int cartasFaltantes(){
        int actuales = cartas.size();
        return 8 - actuales;
    }

    //Post: Agrega una lista de cartas del Mazo a mi lista de cartas
    public void agregarCartas(List<Carta> cartasNuevas) {
        cartas.addAll(cartasNuevas);
    }


    //! MÉTODOS RELACIONADOS A MANO:

    // Post: Selecciona una carta de mi lista de cartas y la agrega a mi mano
    public void seleccionarCarta(Carta cartaCarta){
        mano.agregarCarta(cartaCarta);
        cartas.remove(cartaCarta);
    }

    // Post: Deshace la elección de cartas de mi mano
    public void cancelarEleccion(){
        List<Carta> cartasAReintegrar = mano.cartasAcumuladas(new ArrayList<>());
        cartas.addAll(cartasAReintegrar);
        mano.vaciarMano();
    }

    // Post: Descarta la mano actual y la agrega a la pila de descarte
    public  void descartarMano(){
        this.cantidadDescartes--;
        cartasDescartadas.descartarMano(mano);
        mano.vaciarMano();

        for (Joker joker: jokers){
            joker.activar(mano, "Descarte");
        }

       // cartasDescartadas.reinsertarEnMazo(mazo);
        this.agregarCartasFaltantes();
    }

    //! MÉTODOS RELACIONADOS A JOKER:

    // Post: Agrega un Joker a mi lista de Jokers si no tengo 5
    public void agregarJoker(Joker joker) {
        if (jokers.size() < 5){
            jokers.add(joker);
        }
    }

    // Post: Elimina un Joker de mi lista de Jokers
    public  void eliminarJoker(Joker joker){
        jokers.remove(joker);
    }



    //! MÉTODOS RELACIONADOS A TAROT:

    // Post: Agrega un Tarot a mi lista de Tarots si no tengo 2
    public void agregarTarot(Tarot tarot) {
        if (tarots.size() < 2){
            tarots.add(tarot);
        }
    }

    // Post: Elimina un Tarot de mi lista de Tarots
    public void eliminarTarot(Tarot tarot){
        tarots.remove(tarot);
    }


    public  void agregarTarot(TarotEnCarta tarot){
        if (tarotsParaCarta.size() < 2){
            tarotsParaCarta.add(tarot);
        }
    }

    public  void eliminarTarot(TarotEnCarta tarot){
        tarotsParaCarta.remove(tarot);
    }

    //TODO: MÉTODOS RELACIONADOS A TIENDA:



    //! MÉTODOS PROPIOS:

    // Post: Juega una mano
    public void jugarMano(){
        this.cantidadJugadas--;
        for (Joker joker: jokers){
            joker.activar(mano, "Mano Jugada");
        }

        puntos += mano.calcularPuntaje();
        mano.vaciarMano();
    }

    // Post: Compara si supero un puntaje
    public Boolean soyMayorA(int puntosASuperar){
        return (puntos >= puntosASuperar);
    }

    public void tomarCartas() {
        mazo.repartirCartas(cartas);
    }

    public boolean quedanDescartes() {
        return cantidadDescartes > 0;
    }

    public boolean quedanJugadas() {
        return cantidadJugadas >= 0;
    }

    public void actualizarCantidadDeManosYDescartes(int manos, int descartes) {
        cantidadJugadas = manos;
        cantidadDescartes = descartes;
    }
}
