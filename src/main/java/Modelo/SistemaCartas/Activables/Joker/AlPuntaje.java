package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;

public class AlPuntaje extends Joker {

    public AlPuntaje(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, String activacion, Efecto efecto) {
        super(nombre, descripcion, incrementador, multiplicador, activacion, efecto);
    }

    @Override
    public void activar(Mano mano, String contexto) {
        efecto.activar(incrementador, multiplicador, mano);
    }


}
