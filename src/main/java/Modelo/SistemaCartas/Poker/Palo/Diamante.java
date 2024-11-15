package Modelo.SistemaCartas.Poker.Palo;

// Importaciones

public class Diamante extends Palo {

    // Atributos

    // Constructor
    public Diamante() { super("Diamantes"); }

    // Métodos
    @Override
    public boolean esPalo(String palo) { return palo.equals(this.getNombre());  }
}
