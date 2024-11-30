package Modelo.SistemaCartas.Activables.Tarot;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarJugada;

public class MejoraJugada extends Tarot{
    public MejoraJugada(String nombre, String descripcion, int puntaje, int multiplicador, String jugada){
        super(nombre,descripcion,puntaje,multiplicador);
        this.efecto= new MejorarJugada(jugada);
    }
}
