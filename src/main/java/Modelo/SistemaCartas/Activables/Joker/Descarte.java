package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MultiplicacionMult;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.SumaPuntaje;

public class Descarte extends Joker {
    public Descarte(String nombre, String descripcion, int puntaje, int multiplicador){
        super(nombre,descripcion,puntaje,multiplicador);
        if (puntaje ==1 ){
            this.efecto = new MultiplicacionMult();
        }
        else{
            this.efecto = new SumaPuntaje();
        }
    }
}
