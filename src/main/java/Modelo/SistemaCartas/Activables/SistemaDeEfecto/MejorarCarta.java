package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaPuntaje.Multiplicador;

public class MejorarCarta implements EfectoEnCarta{

    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Carta carta) {
        carta.cambiarPuntaje(incrementador, multiplicador);
    }
}
