package Modelo.SistemaCartas.Poker.Palo;

// Importaciones

import java.util.Objects;

public class Corazon extends Palo {

    // Atributos

    // Constructor
    public Corazon() { super("Corazones"); }

    // Métodos
    @Override
    public boolean esPalo(String palo) { return Objects.equals(palo, this.getNombre());  }

    @Override
    public boolean somosMismoPalo(Palo palo) {
        return palo instanceof Corazon;
    }
}