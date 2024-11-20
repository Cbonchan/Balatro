package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;
import Modelo.SistemaPuntaje.Multiplicador;

public class EfectoDescarte extends Efecto {
    public EfectoDescarte() {
        super("Descarte");
    }
    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){
        if (validarEfecto("Descarte")){
            jugador.aumentarChips(puntaje, multiplicador);
            this.activado = true;
        }

        return;
    }

    @Override
    public Boolean fueActivado(){
        return activado;
    }
}
