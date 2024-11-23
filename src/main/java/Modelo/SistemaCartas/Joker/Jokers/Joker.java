package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.Usuario.Jugador;

public interface Joker {

    public void activar(Jugador jugador);

    public String getDescripcion();
}
