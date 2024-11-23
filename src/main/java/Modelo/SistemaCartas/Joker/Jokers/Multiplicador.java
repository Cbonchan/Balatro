package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.SistemaCartas.Joker.SistemaDeEfecto.MultiplicacionMult;

public class Multiplicador extends JokerGenerico {

    public Multiplicador(String nombre, String descripcion, int puntaje, int multiplicador) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto= new MultiplicacionMult();
    }

}
