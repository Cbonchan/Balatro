package Modelo.SistemaCartas.Joker.SistemaDeEfecto;

import Modelo.Jugador.Jugador;

import java.util.Random;

public class EfectoAutodestruccion implements Efecto{
    private final Random random;
    private final int probabilidad;


    public EfectoAutodestruccion(int probabilidad, Random random) {

        this.probabilidad = probabilidad;
        this.random = random;

    }

    private boolean seActivo(){
        return random.nextInt(probabilidad) == 0;
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        if(!this.seActivo()){
            if (puntos == 1){
                jugador.multiplicarMultiplicador(multiplicador);
            } else{
                jugador.aumentarPuntos(puntos);
            }
        }
    }

}
