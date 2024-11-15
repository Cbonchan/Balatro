package Modelo.SistemaCartas.Poker.Palo;

// Importaciones

public class Trebol extends Palo {

    // Atributos

    // Constructor
    public Trebol() { super("Tréboles"); }

    // Métodos
    @Override
    public boolean esPalo(String palo) { return palo.equals(this.getNombre());  }
}
