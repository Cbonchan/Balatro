package Modelo.SistemaCartas.Activables.Joker;

import Modelo.Usuario.Mano;
import Modelo.SistemaCartas.Activables.Activable;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Combinacion implements Activable {
    private final String nombre;
    private final String descripcion;
    private final ArrayList<Activable> subcomodines;

    public Combinacion(String nombre, String descripcion, ArrayList<Activable> subcomodines){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subcomodines = subcomodines;
    }


    public void activar(Mano mano, String contexto) {
        for (Activable comodin : subcomodines) {
            comodin.activar(mano, contexto);
        }
    }

    public String getDescripcion(){
        return descripcion;
    }

    // Agregado por error al ejecutar JAVA FX
    @Override
    public Image getImage() {
        return null;
    }
}
