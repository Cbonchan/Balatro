package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;

public class EfectoAutomatico extends Efecto {
    public EfectoAutomatico() {
        super("Automatico");
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        jugador.sumarMultiplicador(multiplicador);
        return;
    }
}
