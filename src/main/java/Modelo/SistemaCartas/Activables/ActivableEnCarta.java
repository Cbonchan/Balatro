package Modelo.SistemaCartas.Activables;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.Usuario.Mano;

public interface ActivableEnCarta {

    public  void activar(Carta carta, String contexto);
}
