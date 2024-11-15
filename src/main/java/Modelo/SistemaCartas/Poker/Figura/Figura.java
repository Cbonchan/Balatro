package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

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
    abstract public int orden();
    abstract public int devolverPuntaje();
    abstract public boolean LeSigueA(Figura figura);
}

