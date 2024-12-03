package Modelo.SistemaCartas.Activables.Tarot;

import Modelo.SistemaCartas.Activables.ActivableEnCarta;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.EfectoEnCarta;
import Modelo.SistemaCartas.Cartas.Carta;
import Modelo.SistemaPuntaje.Multiplicador;

public abstract class TarotEnCarta implements ActivableEnCarta {

    protected final String nombre;
    protected final String descripcion;
    protected final int incrementador;
    protected final Multiplicador multiplicador;
    protected EfectoEnCarta efecto;

    public TarotEnCarta(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, EfectoEnCarta efecto) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incrementador = incrementador;
        this.multiplicador = multiplicador;
        this.efecto = efecto;

    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public  abstract void activar(Carta carta, String contexto);

}
