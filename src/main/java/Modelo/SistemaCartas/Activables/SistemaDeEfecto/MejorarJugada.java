package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Jugador;

public class MejorarJugada implements Efecto {
    private final String jugada;

    public MejorarJugada(String jugada) {
        this.jugada = jugada;
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        jugador.mejorarJugada(puntos, multiplicador, jugada);
    }
}
