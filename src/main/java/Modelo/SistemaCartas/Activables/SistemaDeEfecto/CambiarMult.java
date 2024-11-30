package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Jugador;

public class CambiarMult implements Efecto {

    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){

        jugador.cambiarMultiplicador(multiplicador);
    }


}