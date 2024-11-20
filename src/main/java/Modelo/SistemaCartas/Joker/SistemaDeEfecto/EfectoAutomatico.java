package Modelo.SistemaCartas.Joker.SistemaDeEfecto;
import Modelo.Jugador.Jugador;

public class EfectoAutomatico extends Efecto {
    public EfectoAutomatico() {
        super("Automatico");
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        if(validarEfecto("Automatico")){
            jugador.sumarMultiplicador(multiplicador);
            this.activado = true;
        }
        return;
    }

    @Override
    public Boolean fueActivado(){
        return activado;
    }
}
