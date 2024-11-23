package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Usuario.Jugador;

public class EfectoSuma implements Efecto {

    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
            jugador.aumentarPuntos(puntos);
    }


}
