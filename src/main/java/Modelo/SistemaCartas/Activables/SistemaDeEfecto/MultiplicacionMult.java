package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Multiplicador;

public class MultiplicacionMult implements Efecto {


    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano, int puntos) {
        mano.multiplicarMultiplicador(multiplicador);
    }


}
