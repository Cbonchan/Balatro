package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.SistemaPuntaje.Multiplicador;

public class EfectoUnoEn extends Efecto {
    public EfectoUnoEn() {
        super("1 en:");
    }
    @Override
    public void activar(int puntaje, Multiplicador multiplicador){
        return;
    }
}
