package Modelo.SistemaCartas.Joker.Jokers;

import Modelo.Usuario.Jugador;
import Modelo.SistemaCartas.Joker.SistemaDeEfecto.Efecto;

public abstract class JokerGenerico implements Joker {

    protected final String nombre;
    protected final String descripcion;
    protected final int puntaje;
    protected final int multiplicador;
    protected Efecto efecto;

    public JokerGenerico(String nombre, String descripcion, int puntaje, int multiplicador) {

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