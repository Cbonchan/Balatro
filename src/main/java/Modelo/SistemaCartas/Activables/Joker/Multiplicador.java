package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MultiplicacionMult;

public class Multiplicador extends Joker {

    public Multiplicador(String nombre, String descripcion, int puntaje, int multiplicador) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.efecto= new MultiplicacionMult();
    }

}
