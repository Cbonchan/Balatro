package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;

public class EfectoDescarte extends Efecto {
    public EfectoDescarte() {
        super("Descarte");
    }
    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){
        jugador.aumentarChips(puntaje, multiplicador);
        return;
    }
}
