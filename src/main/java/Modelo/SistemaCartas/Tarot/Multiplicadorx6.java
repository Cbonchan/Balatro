package Modelo.SistemaCartas.Tarot;

//! No hace falta mencionar que estoy hay que borrarlo

import Modelo.SistemaCartas.Poker.CartaPoker;

public class Multiplicadorx6  extends  Tarot{
    // Atributos
    private int multiplicador;

    // Constructor
    public void MultiplicadorX6() {
        this.multiplicador = 6;
    }

    // Métodos
    @Override
    public void usar(CartaPoker carta) {
        carta.setMultiplicador(multiplicador);
    }
}