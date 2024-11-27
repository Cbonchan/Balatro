package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Jugador;

public class ActivacionJugada implements Efecto{
    private final String jugada;
    public ActivacionJugada(String jugada) {
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