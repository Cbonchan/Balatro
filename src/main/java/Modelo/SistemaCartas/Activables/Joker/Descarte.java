package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Multiplicador;

public class Descarte extends Joker {


    // Constructor
    public Descarte(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, Efecto efecto) {
        super(nombre, descripcion, incrementador, multiplicador, "Descarte", efecto);
    }


    // Viejo constructor
   /* public Descarte(String nombre, String descripcion, int puntaje, int multiplicador){
        super( nombre, descripcion, puntaje, new Multiplicador(multiplicador), "Descarte");
    }*/


    @Override
    public void activar(Mano mano, String contexto) {
        if ( activacion.equals(contexto))  {
            efecto.activar(this.incrementador, this.multiplicador, mano);
        }
    }

}

