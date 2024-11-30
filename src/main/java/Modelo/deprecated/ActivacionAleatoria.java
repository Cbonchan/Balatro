package Modelo.deprecated;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.Usuario.Jugador;

import java.util.Random;

public class ActivacionAleatoria implements Efecto {
    private final Random random;
    private final int probabilidad;


    public ActivacionAleatoria(int probabilidad, Random random) {
        this.probabilidad = probabilidad;
        this.random = random;

    }
/*
    private boolean seActivo(){
        return random.nextInt(this.probabilidad) == 0;
    }
*/

    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        /*if(this.seActivo()){
            if (puntos == 1){
                jugador.multiplicarMultiplicador(multiplicador);
            } else{
                jugador.aumentarPuntos(puntos);
            }
        */}
    }


