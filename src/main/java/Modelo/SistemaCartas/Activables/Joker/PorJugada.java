package Modelo.SistemaCartas.Activables.Joker;

import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;

public class PorJugada extends Joker {
    // Atributos
    private final String jugada;

    // Constructor
    public PorJugada(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, String jugada,  Efecto efecto) {
        super(nombre, descripcion, incrementador, multiplicador, "Mano Jugada",  efecto);

        this.jugada = jugada;
    }


    // Métodos

    // Post: Se activa el efecto del Joker
    @Override
    public void activar(Mano mano, String contexto) {
        if ( activacion.equals(contexto) && mano.validarNombreMano(jugada) ) {
            efecto.activar(this.incrementador, this.multiplicador, mano);
        }
    }

}
