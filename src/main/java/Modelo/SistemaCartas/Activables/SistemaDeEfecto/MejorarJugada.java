package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class MejorarJugada implements Efecto {
    private final String jugada;

    public MejorarJugada(String jugada) {
        this.jugada = jugada;
    }

    // El puntaje de la jugada se suma en "incrementador" y "multiplicador"
    // incrementador suma a los Chips y multiplicador se suma con Multiplicador
    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano) {
        mano.mejorarJugada(incrementador, multiplicador, jugada);
    }


}
