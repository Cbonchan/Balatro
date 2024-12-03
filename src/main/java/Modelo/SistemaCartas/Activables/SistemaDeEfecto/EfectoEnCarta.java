package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaPuntaje.Multiplicador;

public interface EfectoEnCarta {

    void activar(int incrementador, Multiplicador multiplicador, Carta carta);
}
