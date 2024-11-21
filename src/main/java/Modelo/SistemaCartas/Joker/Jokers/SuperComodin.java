package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.Jugador.Jugador;

import java.util.ArrayList;

public class SuperComodin implements Joker {
    private final String nombre;
    private final String descripcion;
    private final ArrayList<Joker> subcomodines;

    public SuperComodin(String nombre, String descripcion, ArrayList<Joker> subcomodines){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subcomodines = subcomodines;
    }

    public void activar(Jugador jugador){
        for (int i = 0; i < subcomodines.size(); i++){
            subcomodines.get(i).activar(jugador);
        }
    }
    public String getDescripcion(){
        return descripcion;
    }
}
