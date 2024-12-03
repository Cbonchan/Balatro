package Modelo.Usuario;

// Importaciones

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    // Atributos
    private final PilaDescarte cartasDescartadas;
    private final List<Carta> cartas;          // Cartas para elegir max 8
    private final List<Joker> jokers;         // Jokers para activar max 5
    private final List<Tarot> tarots;          // Tarots para activar max 2
    private final Mazo mazo;
    private final Mano mano;
    private int puntos;

    // Constructor
    public Jugador(){
        this.cartas = new ArrayList<>();
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.mano = new Mano();
        this.mazo = new Mazo();
        this.puntos = 0;
        this.cartasDescartadas = new PilaDescarte();
    }

    //! Getters y Setters

    public int getPuntos(){
        return puntos;
    }

    public int obtenerChips(){
        return (mano.obtenerChips());
    }

    public int getCantidadCartas() {
        return cartas.size();
    }

    public List<Carta> obtenerCartas(){return cartas;}

    public Mano obtenerMano(){return mano;}
    // Métodos

    //! MÉTODOS RELACIONADOS A MAZO:


    // Post: Rellena la mano hasta tener 8 Cartas
    public void agregarCartasFaltantes() {
        mazo.repartirCartas(cartas);
    }

    //! EN DUDA
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

    // Públicos

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
        cartasDescartadas.descartarMano(mano);

        for (Joker joker: jokers){
            joker.activar(mano, "Descarte");
        }

        cartasDescartadas.reinsertarEnMazo(mazo);
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

    //Post: activa Jokers correspondientes tras realizar una jugada
    private void chequearJokersDescarte(Mano mano, int puntaje){
        for(Joker joker: this.jokers){
            joker.activar(mano, "Descarte");
        }
    }

    //Post: activa Jokers correspondientes tras realizar una jugada
    private void chequearJokersJugada(Mano mano, int puntaje){
        for(Joker joker: this.jokers){
            joker.activar(mano, "Jugada");
        }
    }




    //! METODOS RELACIONADOS A TAROT:

    // Post: Agrega un Tarot a mi lista de Tarots si no tengo 2
    public void agregarTarot(Tarot tarot) {
        if (tarots.size() < 2){
            tarots.add(tarot);
        }
    }

    // Post: Elimina un Tarot de mi lista de Tarots
    public void venderTarot(Tarot tarot){
        tarots.remove(tarot);
    }


    //TODO: METODOS RELACIONADOS A TIENDA:





    //! METODOS PROPIOS:

    // Post: Juega una mano
    public void jugarMano(){

        for (Joker joker: jokers){
            joker.activar(mano, "Mano Jugada");
        }

        puntos = mano.calcularPuntaje();
        mano.vaciarMano();

        //Mano CalcularPuntaje(Jokers) -> Calculo mi mano teniendo en cuenta los Jokers
        //chequearJokersJugada(Jugada, PuntajeLocal) -> Se chequean los Jokers dentro del calcular puntaje
        // de mano
        //Me devuelve el puntaje final
        // chequeo jokers que afecten al puntaje final
        //reset Mano
        //me guardo el puntaje final
    }

    // Post: Compara si supero un puntaje
    public Boolean soyMayorA(int puntosASuperar){
        return (puntos >= puntosASuperar);
    }

    public void tomarCartas() {
        mazo.repartirCartas(cartas);
    }
}
