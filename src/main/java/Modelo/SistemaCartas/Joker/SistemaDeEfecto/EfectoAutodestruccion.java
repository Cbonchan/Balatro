package Modelo.SistemaCartas.Joker.SistemaDeEfecto;

import Modelo.Jugador.Jugador;

import java.util.Random;

public class EfectoAutodestruccion extends Efecto{
    private Random random;
    private int probabilidad;


    public EfectoAutodestruccion(int probabilidad, Random random) {
        super("Automatico"); //dejar en automatico porque es como se activa, no el "que" se activa
        this.probabilidad = probabilidad;
        this.random = random;

    }

    private boolean unoEn(){
        return random.nextInt(probabilidad) == 0;
    }
    @Override
    public void activar(int puntos, int multiplicador, Jugador jugador){
        if(!this.unoEn() && validarEfecto("Automatico")){
            jugador.sumarMultiplicador(multiplicador);
            activado = true;

        }
        return;
    }
    @Override
    public Boolean fueActivado(){
        return activado;
    }
}
