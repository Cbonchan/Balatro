package Modelo.SistemaCartas.Poker.Figura;

// importaciones

public class Rey extends Figura {
    // Atributos

    // Constructor
    public Rey() {
        super("K");
    }

    // Métodos
    @Override
    public int orden() {
        return 13;
    }

    @Override
    public int devolverPuntaje() {
        return 10;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Reina;
    }
}