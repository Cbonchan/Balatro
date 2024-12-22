package Modelo.SistemaCartas.Cartas.Palo;

// Importaciones

public class Trebol extends Palo {

    // Atributos

    // Constructor
    public Trebol() { super("Treboles"); }

    @Override
    public boolean somosMismoPalo(Palo palo) {
        return palo instanceof Trebol;
    }
}
