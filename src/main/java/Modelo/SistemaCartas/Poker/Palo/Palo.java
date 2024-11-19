package Modelo.SistemaCartas.Poker.Palo;

// Importaciones

public abstract class Palo {
    // Atributos
    private final String nombre;

    // Constructor
    public Palo(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    // Métodos

    // Post: Devuelve true si el palo es igual al palo de la instancia
    abstract public boolean somosMismoPalo(Palo palo);


    // Duda

    // Post: Devuelve true si el palo es igual al palo de la instancia
    abstract public boolean esPalo(String palo);


}
