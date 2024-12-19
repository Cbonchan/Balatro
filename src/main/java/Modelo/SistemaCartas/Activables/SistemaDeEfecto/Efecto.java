package Modelo.SistemaCartas.Activables.SistemaDeEfecto;

import Modelo.Usuario.Mano;
import Modelo.SistemaPuntaje.Multiplicador;

public interface Efecto {

    void activar(int incrementador, Multiplicador multiplicador, Mano mano);


}
