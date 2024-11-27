package Modelo.SistemaCartas.Activables.SistemaDeEfecto;
import Modelo.Usuario.Jugador;

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
