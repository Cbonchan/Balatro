package Modelo.SistemaCartas.Cartas.Palo;

// Importaciones

public class Corazon extends Palo {

    // Atributos

    // Constructor
    public Corazon() { super("Corazones"); }

    @Override
    public boolean somosMismoPalo(Palo palo) {
        return palo instanceof Corazon;
    }
}