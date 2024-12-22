package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class CambiarMult implements Efecto {

    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano) {
        mano.cambiarMultiplicadorPor(multiplicador);
    }


}