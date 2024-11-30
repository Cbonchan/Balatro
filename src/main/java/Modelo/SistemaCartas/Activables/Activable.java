package Modelo.SistemaCartas.Activables;

import Modelo.Usuario.Jugador;

public interface Activable {

    public void activar(Jugador jugador);

    public String getDescripcion();
}
