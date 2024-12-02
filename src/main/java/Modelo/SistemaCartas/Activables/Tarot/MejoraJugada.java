package Modelo.SistemaCartas.Activables.Tarot;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.MejorarJugada;
import Modelo.SistemaCartas.Poker.Carta;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class MejoraJugada extends Tarot{
    public MejoraJugada(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, String jugada, Efecto efecto){
        super(nombre,descripcion, incrementador, multiplicador, efecto);
        this.efecto= new MejorarJugada(jugada);
    }

    @Override
    public void activar(Mano mano, String contexto) {
        this.efecto.activar(incrementador, multiplicador, mano);
    }
}
