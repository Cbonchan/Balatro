package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Jugador.Jugador;

public class EfectoUnoEn extends Efecto {
    public EfectoUnoEn() {
        super("1 en:");
    }
    @Override
    public void activar(int puntaje, int multiplicador,  Jugador jugador){
        return;
    }
}
