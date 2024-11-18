package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.SistemaPuntaje.Multiplicador;

public class EfectoDescarte extends Efecto {
    public EfectoDescarte() {
        super("Descarte");
    }
    @Override
    public void activar(int puntaje, Multiplicador multiplicador){
        return;
    }
}
