package Modelo.SistemaCartas.Cartas.Palo;

// Importaciones

public class Pica extends Palo {

    // Atributos

    // Constructor
    public Pica() { super("Picas"); }

    @Override
    public boolean somosMismoPalo(Palo palo) {
        return palo instanceof Pica;
    }
}