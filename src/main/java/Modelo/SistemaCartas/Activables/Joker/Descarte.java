package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.ActivacionDescarte;

public class Descarte extends Joker {
    public Descarte(String nombre, String descripcion, int puntaje, int multiplicador){
        super(nombre,descripcion,puntaje,multiplicador);
        this.efecto = new ActivacionDescarte();
    }


}
