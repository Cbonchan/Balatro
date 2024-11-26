package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.Usuario.Jugador;

import java.util.ArrayList;

public class Combinacion implements Activable {
    private final String nombre;
    private final String descripcion;
    private final ArrayList<Activable> subcomodines;

    public Combinacion(String nombre, String descripcion, ArrayList<Activable> subcomodines){
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
