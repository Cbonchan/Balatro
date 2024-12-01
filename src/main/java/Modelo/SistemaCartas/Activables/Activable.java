package Modelo.SistemaCartas.Activables;

import Modelo.Usuario.Mano;

public interface Activable {

    public  void activar(Mano mano, int puntos, String contexto);

    public String getDescripcion();
}
