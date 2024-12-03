package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Multiplicador;

public interface Efecto {

    /*
    public Boolean validarEfecto(String Efecto) {
        return activacion.equals(Efecto);
    }
     */

    void activar(int incrementador, Multiplicador multiplicador, Mano mano);


}
