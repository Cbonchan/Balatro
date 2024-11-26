package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.ActivacionJugada;

public class PorJugada extends Joker {
    public PorJugada(String nombre, String descripcion, int puntaje, int multiplicador, String jugada) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new ActivacionJugada(jugada);
    }

}
