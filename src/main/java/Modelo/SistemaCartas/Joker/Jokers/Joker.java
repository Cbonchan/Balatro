package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.Jugador.Jugador;

public interface Joker {

    public void activar(Jugador jugador);

    public String getDescripcion();
}
