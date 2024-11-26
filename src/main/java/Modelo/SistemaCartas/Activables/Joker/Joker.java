package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.Activable;
import Modelo.Usuario.Jugador;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;

public abstract class Joker implements Activable {

    protected final String nombre;
    protected final String descripcion;
    protected final int puntaje;
    protected final int multiplicador;
    protected Efecto efecto;

    public Joker(String nombre, String descripcion, int puntaje, int multiplicador) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;


    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void activar(Jugador jugador){
        efecto.activar(this.puntaje, this.multiplicador, jugador);
    }
}