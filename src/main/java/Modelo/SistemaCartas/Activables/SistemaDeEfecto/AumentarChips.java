package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Jugador;

public class AumentarChips implements Efecto {

    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        jugador.aumentarChips(puntos, multiplicador);
    }
}
