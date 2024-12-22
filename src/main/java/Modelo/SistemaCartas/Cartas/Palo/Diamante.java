package Modelo.SistemaCartas.Cartas.Palo;

// Importaciones

public class Diamante extends Palo {

    // Atributos

    // Constructor
    public Diamante() { super("Diamantes"); }

    @Override
    public boolean somosMismoPalo(Palo palo) {
        return palo instanceof Diamante;
    }
}
