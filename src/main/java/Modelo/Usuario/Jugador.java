package Modelo.Usuario;

// Importaciones
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.Tarot.Tarot;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.Juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    // Atributos

    private List<Carta> cartas;
    private List<Joker> jokers;
    private List<Tarot> tarots;
    private Mano mano;
    private Mazo mazo;

    private int puntaje;
    // Constructor
    public Jugador(){
        this.cartas = new ArrayList<>();
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.mano = new Mano(); // Suponiendo que Mano tiene un constructor sin parámetros
        this.mazo = new Mazo(); // Suponiendo que Mazo tiene un constructor sin parámetros
        this.puntaje = 0; // Inicializamos el puntaje en 0
    }


    //? Por que Jugador recibe Mano y no la crea el mismo?
    //? BORRAR CAMILO
    public Jugador(Mano mano) {
        this.puntaje = 0;
        this.cartas = new ArrayList<>();
        this.mano = mano;


    }


    //! Getters

    private void asignarPuntaje(int puntajeEntrante) {
        puntaje += puntajeEntrante;
    }

    public int getCantidadCartas() {
        return cartas.size();
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int obtenerChips(){
        return (mano.obtenerChips());
    }

    // Métodos

    //! METODOS RELACIONADOS A MAZO:


    public void agregarCartas(List<Carta> cartasNuevas) {
        cartas.addAll(cartasNuevas);
    }


    //! METODOS RELACIONADOS A MANO:


    public void seleccionarCarta(Carta cartaCarta){
        mano.agregarCarta(cartaCarta);
        cartas.remove(cartaCarta);
    }

    public void quitarCartas(Mano mano){
        List<Carta> cartasARemover = new ArrayList<>();
        cartasARemover = mano.cartasAcumuladas(cartasARemover);
        cartas.removeAll(cartasARemover);
    }

    public void deshacerEleccion(){
        List<Carta> cartasAReintegrar = mano.cartasAcumuladas(new ArrayList<>());
        cartas.addAll(cartasAReintegrar);
        mano.vaciarMano();
    }

    public void descartarMano(Tablero tablero){
        tablero.descarteMano(mano);
        this.quitarCartas(mano);
        mano.vaciarMano();
    }

    public boolean validarMano(String manoAValidar){
        return this.mano.validarNombreMano(manoAValidar);
    }

    public void mejorarJugada(int puntos, int multiplicador, String jugada){
        this.mano.mejorarJugada(puntos, multiplicador, jugada);
    }

        //! PUNTAJE DE MANO:

    public void aumentarChips(int puntaje, int multiplicador){
        this.mano.aumentarChips(puntaje, multiplicador);
    }

    public void aumentarPuntos(int puntaje){
        this.puntaje += puntaje;
    }

    public void cambiarChips(int chips){
        this.mano.cambiarChip(chips);
    }

    public void sumarMultiplicador(int multiplicador){
        mano.sumarMultiplicador(multiplicador);
    }

    public void multiplicarMultiplicador(int multiplicador){
        mano.multiplicarMultiplicador(multiplicador);
    }

    public void cambiarMultiplicador(int multiplicador){
        this.mano.cambiarMult(multiplicador);
    }



    //! METODOS RELACIONADOS A JOKER:

    //Post: activa Jokers correspondientes tras realizar una jugada
    private void chequearJokersDescarte(Mano mano, int puntaje){
        for(Joker joker: this.jokers){
            joker.activar(mano, puntaje);
        }
    }

    //Post: activa Jokers correspondientes tras realizar una jugada
    private void chequearJokersJugada(Mano mano, int puntaje){
        for(Joker joker: this.jokers){
            joker.activar(mano, puntaje);
        }
    }

    //! METODOS RELACIONADOS A TAROT:

    //TODO: METODOS RELACIONADOS A TIENDA:



    //! METODOS PROPIOS:
    public void jugar(Tablero tablero){
        int valor = tablero.jugarMano(mano);

        this.quitarCartas(mano);

        asignarPuntaje(valor);
        mano.vaciarMano();
    }


    public void jugarMano(){

        chequearJokers(mano, puntaje);
        int puntos = mano.calcularPuntaje();

        //Mano CalcularPuntaje(Jokers) -> Calculo mi mano teniendo en cuenta los Jokers
        //chequearJokersJugada(Jugada, PuntajeLocal) -> Se chequean los Jokers dentro del calcular puntaje
                                                        // de mano
        //Me devuelve el puntaje final
        // chequeo jokers que afecten al puntaje final
        //reset Mano
        //me guardo el puntaje final

    }


    public Boolean soyMayorA(int puntosASuperar){
        return (puntaje >= puntosASuperar);
    }

    public int cartasFaltantes(){
        int actuales = cartas.size();
        return 8 - actuales;
    }
}
