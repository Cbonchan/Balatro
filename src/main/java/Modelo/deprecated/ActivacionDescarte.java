package Modelo.deprecated;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class ActivacionDescarte implements Efecto {


    @Override
    public void activar(int incrementador, Multiplicador multiplicador, Mano mano, int puntos) {
            if ( incrementador == 1){
                mano.sumarMultiplicador(multiplicador);
            } else {
                mano.aumentarPuntos(incrementador);
            }
    }

}
