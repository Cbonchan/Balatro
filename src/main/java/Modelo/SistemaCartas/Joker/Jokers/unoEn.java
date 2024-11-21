package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.ActivacionAleatoria;

import java.util.Random;

public class unoEn extends JokerGenerico {

    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad){
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new ActivacionAleatoria(probabilidad, new Random());
    }

    //TESTING

    public unoEn(String nombre, String descripcion, int puntaje, int multiplicador, int probabilidad, Random FProbabilidad){
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto = new ActivacionAleatoria(probabilidad, FProbabilidad);
    }
/*
    public boolean FueActivado(){
        return this.efecto.seActivo();
    }*/
}
