package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class Reina extends Figura {
    // Atributos

    // Constructor
    public Reina() {super("Q");}

    // Métodos
    @Override
    public int orden() {
        return 12;
    }

    @Override
    public int devolverPuntaje() {
        return 10;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Jota;
    }

}