package Modelo.SistemaCartas.Activables.Joker;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;
import Modelo.Usuario.Jugador;

public class PorJugada extends Joker {
    private final String jugada;

    public PorJugada(String nombre, String descripcion, int puntaje, int multiplicador, String jugada) {
        super(nombre, descripcion, puntaje, multiplicador);
        this.jugada = jugada;
        if (puntaje == 1){
            this.efecto = new SumarMult();
        }
        else{
            this.efecto = new AumentarChips();
        }
    }

    @Override
    public void activar(Jugador jugador){
        if (jugador.validarMano(jugada)) {
            efecto.activar(this.puntaje, this.multiplicador, jugador);
        }
    }
}
