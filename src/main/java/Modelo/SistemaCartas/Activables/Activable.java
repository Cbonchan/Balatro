package Modelo.SistemaCartas.Activables;


import Modelo.SistemaCartas.Poker.Carta;
import Modelo.Usuario.Mano;

public interface Activable {

    public  void activar(Mano mano, String contexto);

    public String getDescripcion();
}
