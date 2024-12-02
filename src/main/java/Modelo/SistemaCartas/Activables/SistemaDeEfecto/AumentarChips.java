package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Chip;
import Modelo.SistemaPuntaje.Multiplicador;

public class AumentarChips implements Efecto {


    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano) {
        mano.aumentarChips(new Chip(incrementador));
    }

}
