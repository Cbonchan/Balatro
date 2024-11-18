package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.SistemaPuntaje.Multiplicador;

public class EfectoJugada extends Efecto {
    public EfectoJugada() {
        super("Mano Jugada");
    }
    @Override
    public void activar(int cantidad, Multiplicador multiplicador){
        multiplicador.incrementar(cantidad);
        return;
    }
}
