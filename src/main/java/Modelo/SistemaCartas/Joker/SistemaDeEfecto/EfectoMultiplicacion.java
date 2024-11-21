package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;

public class EfectoMultiplicacion implements Efecto {

    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
            jugador.multiplicarMultiplicador(multiplicador);
    }


}
