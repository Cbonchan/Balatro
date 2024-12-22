package Modelo.SistemaCartas.Activables;


import Modelo.Usuario.Mano;
import javafx.scene.image.Image;

public interface Activable {

    public  void activar(Mano mano, String contexto);

    public String getDescripcion();

    public Image getImage();

}
