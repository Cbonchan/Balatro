package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class As extends Figura {

    // Atributos

    // Constructor
    public As() { super("As");}

    // Métodos
    @Override
    public int orden() {return 1;
    }

    @Override
    public int devolverPuntaje() {return 11;}

    @Override
    public boolean LeSigueA(Figura figura) { return figura instanceof K;}

}