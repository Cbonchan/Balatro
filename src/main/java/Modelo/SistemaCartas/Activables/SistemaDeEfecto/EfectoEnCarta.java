package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public interface EfectoEnCarta {

    void activar(int incrementador, Multiplicador multiplicador, Carta carta);
}
