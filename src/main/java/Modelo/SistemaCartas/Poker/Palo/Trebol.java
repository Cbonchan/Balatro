package Modelo.SistemaCartas.Poker.Palo;

// Importaciones

public class Trebol extends Palo {

    // Atributos

    // Constructor
    public Trebol() { super("Treboles"); }

    // Métodos
    @Override
    public boolean esPalo(String palo) { return palo.equals(this.getNombre());  }

    @Override
    public boolean somosMismoPalo(Palo palo) {
        return palo instanceof Trebol;
    }
}
