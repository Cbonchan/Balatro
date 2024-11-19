package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Jugador.Jugador;

public class EfectoJugada extends Efecto {
    public EfectoJugada() {
        super("Mano Jugada");
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        jugador.sumarMultiplicador(multiplicador);
        return;
    }
}
