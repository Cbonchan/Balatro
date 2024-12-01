package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class SumarMultiplicador implements Efecto {

    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano, int puntos) {
        mano.sumarMultiplicador(multiplicador);
    }
}