package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.EfectoPorJugada;

public class JokerPorJugada extends JokerGenerico {
    public JokerPorJugada(String nombre, String descripcion, int puntaje, int multiplicador, String jugada) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new EfectoPorJugada(jugada);
    }

}
