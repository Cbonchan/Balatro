package Modelo.SistemaCartas.Poker.Palo;

// Importaciones

public class Pica extends Palo {

    // Atributos

    // Constructor
    public Pica() { super("Picas"); }

    // Métodos
    @Override
    public boolean esPalo(String palo) { return palo.equals(this.getNombre());  }
}