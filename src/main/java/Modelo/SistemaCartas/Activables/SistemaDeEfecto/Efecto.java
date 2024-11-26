package Modelo.SistemaCartas.Activables.SistemaDeEfecto;
import Modelo.Usuario.Jugador;

public interface Efecto {

    /*
    public Boolean validarEfecto(String Efecto) {
        return activacion.equals(Efecto);
    }
     */

    void activar(int puntaje, int multiplicador, Jugador jugador);



}
