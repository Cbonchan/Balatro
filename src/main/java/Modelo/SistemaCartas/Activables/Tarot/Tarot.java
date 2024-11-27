package Modelo.SistemaCartas.Activables.Tarot;

// Importaciones
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Poker.*;
import Modelo.Usuario.Jugador;

public abstract class Tarot implements Activable {

    protected final String nombre;
    protected final String descripcion;
    protected final int puntaje;
    protected final int multiplicador;
    protected Efecto efecto;

    public Tarot(String nombre, String descripcion, int puntaje, int multiplicador) {

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


