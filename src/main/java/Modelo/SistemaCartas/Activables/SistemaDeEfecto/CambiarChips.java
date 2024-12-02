package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Multiplicador;

public class CambiarChips implements Efecto {


    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano) {
        mano.cambiarChipPor(incrementador);
    }


}
