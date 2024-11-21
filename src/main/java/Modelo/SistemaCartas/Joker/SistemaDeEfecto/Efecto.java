package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;
import java.util.Random;

public interface Efecto {

    /*
    public Boolean validarEfecto(String Efecto) {
        return activacion.equals(Efecto);
    }
     */

    void activar(int puntaje, int multiplicador, Jugador jugador);



}
