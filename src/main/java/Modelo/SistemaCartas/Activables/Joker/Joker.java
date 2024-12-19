package Modelo.SistemaCartas.Activables.Joker;

import Modelo.SistemaCartas.Activables.SistemaDeEfecto.*;
import Modelo.Usuario.Mano;
import Modelo.SistemaCartas.Activables.Activable;
import Modelo.SistemaPuntaje.Multiplicador;
import com.google.gson.JsonObject;
import javafx.scene.image.Image;

public abstract class Joker implements Activable {

    // Atributos
    protected final String nombre;
    protected final String descripcion;
    protected final String activacion;
    protected Efecto efecto;
    protected final int incrementador;
    protected final Multiplicador multiplicador;

    // Constructor
    public Joker(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, String activacion, Efecto efecto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activacion = activacion;
        this.efecto = efecto;
        this.incrementador = incrementador;
        this.multiplicador = multiplicador;
    }

    public Joker(String nombre, String descripcion, int incrementador, Multiplicador multiplicador, String activacion) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activacion = activacion; // Debe venir del JSON
        this.incrementador = incrementador;
        this.multiplicador = multiplicador;
    }

    // No sé que factory

    private static Joker crearJokerPorActivacion(JsonObject jokerObject,  String nombre, String descripcion,
            JsonObject activacionObject, Efecto efecto, int incrementador, Multiplicador multiplicador) {


        if (activacionObject.has("Mano Jugada")) {
            String jugadaEspecifica = jokerObject.getAsJsonObject("activacion").get("Mano Jugada").getAsString();

            if (incrementador == 1){
                efecto = new SumarMultiplicador();
            }
            else {
                efecto = new AumentarChips();
            }

            return new PorJugada(nombre, descripcion, incrementador, multiplicador, jugadaEspecifica, efecto);
        }

        else if (activacionObject.has("1 en")) {
            int  limitadorDeProbabilidad = jokerObject.getAsJsonObject("activacion").get("1 en").getAsInt();

            if (incrementador == 1){
                efecto = new MultiplicacionMult();
            }
            else {
                efecto = new SumarPuntaje();
            }

            return new UnoEn(nombre, descripcion, incrementador, multiplicador, limitadorDeProbabilidad, efecto);
        }

        else if (activacionObject.has("Descarte")) {

            if (incrementador == 1){
                efecto = new MultiplicacionMult();
            }
            else {
                efecto = new SumarPuntaje();
            }

            return new Descarte(nombre, descripcion, incrementador, multiplicador, efecto);
        };

        // Falta ver el caso de combinación de jokers
        return null;
    }

    public static Joker leerJson(JsonObject jokerObject) {
        String nombre = jokerObject.get("nombre").getAsString();

        String descripcion = jokerObject.get("descripcion").getAsString();

        JsonObject activacionObject = jokerObject.getAsJsonObject("activacion");

        Efecto efecto = null;   // Un efecto por defecto

        int incrementador = jokerObject.get("puntos").getAsInt();

        Multiplicador multiplicador = new Multiplicador(jokerObject.get("multiplicador").getAsInt());

        // Construir según el grupo de activación
        return crearJokerPorActivacion(jokerObject, nombre, descripcion, activacionObject, efecto, incrementador, multiplicador);
    }

    // Getters y Setters
    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    // Post: Se activa el efecto del Joker
     public  abstract void activar(Mano mano, String contexto);

    public Image getImage() {
        String nombre = this.getNombre();
        String pathname = "/images/Jokers/"+nombre+".png";
        return new Image(Joker.class.getResourceAsStream(pathname));
    }
}