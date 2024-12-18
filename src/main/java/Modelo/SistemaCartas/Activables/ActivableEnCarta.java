package Modelo.SistemaCartas.Activables;

import Modelo.SistemaCartas.Cartas.Carta;
import javafx.scene.image.Image;

public interface ActivableEnCarta {

    public  void activar(Carta carta, String contexto);

    String getDescripcion();

    public Image getImage();

}
