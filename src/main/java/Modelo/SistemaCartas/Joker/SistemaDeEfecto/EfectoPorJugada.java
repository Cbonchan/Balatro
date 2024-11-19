package Modelo.SistemaCartas.Joker.SistemaDeEfecto;

import Modelo.Jugador.Jugador;

public class EfectoPorJugada extends Efecto{
    private String jugada;
    public EfectoPorJugada() {
        super("Mano Jugada");
    }
    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){
        jugador.aumentarChips(puntaje, multiplicador);
        return;
    }
}
