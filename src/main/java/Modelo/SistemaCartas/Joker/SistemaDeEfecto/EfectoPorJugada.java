package Modelo.SistemaCartas.Joker.SistemaDeEfecto;

import Modelo.Jugador.Jugador;

public class EfectoPorJugada implements Efecto{
    private final String jugada;
    public EfectoPorJugada(String jugada) {
        this.jugada = jugada;

    }
    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){
        if (jugador.validarMano(jugada)){
            if (puntaje == 1){
                jugador.sumarMultiplicador(multiplicador);
            } else {
                jugador.aumentarChips(puntaje, multiplicador);
            }

        }
    }
}