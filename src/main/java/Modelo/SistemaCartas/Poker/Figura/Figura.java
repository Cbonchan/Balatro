package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.Puntaje;


public abstract class Figura {
    // Atributos
    private final String nombre;

    //Constructor
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    //Métodos

    // Métodos abstractos

    // Post: Devuelve el orden de la figura
    abstract public int orden();

    // Post: Devuelve el puntaje de la figura
    abstract public Puntaje asignarPuntaje();

    // Post: Devuelve si la figura es igual a otra figura
    abstract  public  boolean esIgualA(Figura figura);

    // Post: Devuelve si la siguiente figura es igual a otra figura
    abstract  public boolean miSiguienteFiguraEs(Figura figura);


    // Públicos


}

