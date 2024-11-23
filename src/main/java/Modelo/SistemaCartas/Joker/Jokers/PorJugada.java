package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.ActivacionJugada;

public class PorJugada extends JokerGenerico {
    public PorJugada(String nombre, String descripcion, int puntaje, int multiplicador, String jugada) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new ActivacionJugada(jugada);
    }

}
