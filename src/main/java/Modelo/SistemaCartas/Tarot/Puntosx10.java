package Modelo.SistemaCartas.Tarot;

//! No hace falta mencionar que estoy hay que borrarlo

import Modelo.SistemaCartas.Poker.CartaPoker;

public class Puntosx10 extends Tarot {

    // Atributos
    private int puntos;

    // Constructor
    public void PuntosX10(){
        this.puntos = 10;
    }

    //Métodos

    @Override
    public void usar(CartaPoker carta) {
        carta.setPuntaje(puntos);
    }
}
