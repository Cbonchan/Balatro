package Modelo.deprecated;

import Modelo.Usuario.Mano;

import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;

public class ActivacionJugada implements Efecto {

    private final String jugada;
    public ActivacionJugada(String jugada) {
        this.jugada = jugada;

    }

    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano, int puntos) {
        if ( mano.validarNombreMano(jugada) ) {
            if ( incrementador == 1){
                mano.sumarMultiplicador(multiplicador);
            } else {
                mano.aumentarChips(new Chip(incrementador));
            }
        }
    }


}
