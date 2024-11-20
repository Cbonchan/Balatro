package Modelo.SistemaCartas.Joker.SistemaDeEfecto;

import Modelo.Jugador.Jugador;

public class EfectoPorJugada extends Efecto{
    private String jugada;
    public EfectoPorJugada(String jugada) {
        super("Mano Jugada", jugada);
    }
    @Override
    public void activar(int puntaje, int multiplicador, Jugador jugador){
        if (validarEfecto("Mano Jugada") && validarEfectoPorJugada(jugador)){
            jugador.multiplicarMultiplicador(multiplicador);
            this.activado = true;
        }

        return;
    }
    @Override
    public Boolean fueActivado(){
        return activado;
    }
}
