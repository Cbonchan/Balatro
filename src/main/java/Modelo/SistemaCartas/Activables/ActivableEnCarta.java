package Modelo.SistemaCartas.Activables;

import Modelo.SistemaCartas.Cartas.Carta;

public interface ActivableEnCarta {

    public  void activar(Carta carta, String contexto);

    String getDescripcion();
}
