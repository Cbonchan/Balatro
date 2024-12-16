package Modelo.SistemaCartas.Activables.Tarot;

// Importaciones
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaCartas.Activables.Joker.Joker;
import Modelo.SistemaCartas.Activables.SistemaDeEfecto.Efecto;
import Modelo.SistemaPuntaje.Multiplicador;
import Modelo.Usuario.Mano;
import javafx.scene.image.Image;

public abstract class Tarot implements Activable {

    protected final String nombre;
    protected final String descripcion;
    protected final int incrementador;
    protected final Multiplicador multiplicador;
    protected Efecto efecto;


    public Tarot(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, Efecto efecto) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incrementador = incrementador;
        this.multiplicador = multiplicador;
        this.efecto = efecto;

    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public  abstract void activar(Mano mano, String contexto);

    public Image getImage() {
        String nombre = this.getNombre();
        String pathname = "/images/Tarots/"+nombre.replace("", "_")+".png";
        return new Image(Tarot.class.getResourceAsStream(pathname));
    }

}


