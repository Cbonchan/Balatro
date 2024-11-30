package Modelo.Juego;

import Modelo.Usuario.Jugador;

public class Juego {
    Jugador jugador;
    Tablero tablero;

    List<Ronda>rondas[8];

    void comenzarJuego(){
        // inicializamos mazo
        // inicializamos rondas

        for each ronda in rondas:
            rondas.comenzar();

    }

}

public class Ronda{
    private int id;
    private int manos; // cantidad de "jugar" de usuario
    private int descartes; // cantidad de "descarte" de usuario
    private int puntajeASuperar;

    public void comenzar(){
        mazo.repartirCartas()
    }
}