package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;

public class ActivacionDescarte implements Efecto {

    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){

            if (puntaje == 1){
                jugador.multiplicarMultiplicador(multiplicador);
            } else {
                jugador.aumentarPuntos(puntaje);
            }

    }
}
