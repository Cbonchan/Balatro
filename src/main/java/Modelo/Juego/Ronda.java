package Modelo.Juego;

import Modelo.Usuario.Jugador;

public class Ronda {

    // Atributos
    private int nro;
    private int id;
    private int manos; // cantidad de "jugar" de usuario
    private int descartes; // cantidad de "descarte" de usuario
    private int puntajeASuperar;
    private Tienda tienda;

    // Constructor
    public Ronda(int nro, int manos, int descartes, int puntajeASuperar, Tienda tienda) {
        this.nro = nro;
        this.manos = manos;
        this.descartes = descartes;
        this.puntajeASuperar = puntajeASuperar;
        this.tienda = tienda;
    }
    public void comenzar(Jugador jugador) {
        jugador.reiniciarPuntos();
        jugador.agregarCartasFaltantes();
        jugador.actualizarCantidadDeManosYDescartes(manos,descartes);
    }

    public boolean puedoDescartar() {
        return descartes > 0;
    }

    public boolean puedoJugar() {
        return manos >= 0;
    }

    public boolean puedoContinuar() {
        return puedoJugar();
    }

    public boolean superoPuntaje(Jugador jugador) {
        return jugador.soyMayorA(puntajeASuperar);
    }

    //JavaFX getter
    public int getNro() {
        return nro;
    }

    public Tienda getTienda(){
        return tienda;
    }

    public int getPuntajeASuperar() {
        return puntajeASuperar;
    }
}

