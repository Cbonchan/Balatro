package Modelo.SistemaCartas.Activables.Tarot;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarJugada;
import Modelo.Usuario.Mano;

public class MejoraJugada extends Tarot{
    public MejoraJugada(String nombre, String descripcion, int puntaje, int multiplicador, String jugada){
        super(nombre,descripcion,puntaje,multiplicador);
        this.efecto= new MejorarJugada(jugada);
    }

    @Override
    public void activar(Mano mano, int puntos, String contexto) {
        // Implementar
    }
}
