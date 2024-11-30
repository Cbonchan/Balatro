package Modelo.Usuario;

// Importaciones
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.Juego.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    // Atributos
    private int puntaje;
    private List<Carta> cartas;
    private Mano mano;


    // Constructor

    //? Por que Jugador recibe Mano y no la crea el mismo?
    public Jugador(Mano mano) {
        this.puntaje = 0;
        this.cartas = new ArrayList<>();
        this.mano = mano;

    }

    // Getters
    public int getCantidadCartas() {
        return cartas.size();
    }

    public int getPuntaje(){
        return puntaje;
    }



    // Métodos

    public int obtenerMultiplicador(){
        return (mano.obtenerMultiplicador());
    }

    public void sumarMultiplicador(int multiplicador){
        mano.sumarMultiplicador(multiplicador);
    }

    public void multiplicarMultiplicador(int multiplicador){
        mano.multiplicarMultiplicador(multiplicador);
    }

    public int obtenerChips(){
        return (mano.obtenerChips());
    }

    public void aumentarChips(int puntaje, int multiplicador){
        this.mano.aumentarChips(puntaje, multiplicador);
    }
    public void aumentarPuntos(int puntaje){
        this.puntaje += puntaje;
    }

    public void cambiarMultiplicador(int multiplicador){
        this.mano.cambiarMult(multiplicador);
    }

    public void cambiarChips(int chips){
        this.mano.cambiarChip(chips);
    }

    public void mejorarJugada(int puntos, int multiplicador, String jugada){
        this.mano.mejorarJugada(puntos, multiplicador, jugada);
    }

    //si se selecciona una mano pero te arrepentis, con este metodo la mano se vacia
    //solucion momentanea a tener que deseleccionar cartas una por una

    public void deshacerEleccion(){
        List<Carta> cartasAReintegrar = mano.cartasAcumuladas(new ArrayList<>());
        cartas.addAll(cartasAReintegrar);
        mano.vaciarMano();
    }

    public void seleccionarCarta(Carta cartaCarta){
        mano.agregarCarta(cartaCarta);
        cartas.remove(cartaCarta);
    }

    public void jugar(Tablero tablero){
        int valor = tablero.jugarMano(mano);

        this.quitarCartas(mano);

        asignarPuntaje(valor);
        mano.vaciarMano();
    }

    public void descartarMano(Tablero tablero){
        tablero.descarteMano(mano);
        this.quitarCartas(mano);
        mano.vaciarMano();
    }

    public int cartasFaltantes(){
        int actuales = cartas.size();
        return 8 - actuales;
    }

    public void quitarCartas(Mano mano){
        List<Carta> cartasARemover = new ArrayList<>();
        cartasARemover = mano.cartasAcumuladas(cartasARemover);
        cartas.removeAll(cartasARemover);
    }

    public void agregarCartas(List<Carta> cartasNuevas) {
        cartas.addAll(cartasNuevas);
    }

    private void asignarPuntaje(int puntajeEntrante) {
        puntaje += puntajeEntrante;
    }

    public boolean validarMano(String manoAValidar){
       return this.mano.validarNombreMano(manoAValidar);
    }
}
