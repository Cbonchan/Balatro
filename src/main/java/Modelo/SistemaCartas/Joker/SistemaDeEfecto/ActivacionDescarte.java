package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Usuario.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;

public class ActivacionDescarte implements Efecto {

    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){

            if (puntaje == 1){
                jugador.multiplicarMultiplicador(multiplicador);
            } else {
                jugador.aumentarChips(puntaje, multiplicador);
            }

    }


}
