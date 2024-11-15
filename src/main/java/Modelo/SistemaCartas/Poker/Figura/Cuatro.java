package Modelo.SistemaCartas.Poker.Figura;

public class Cuatro extends Figura{
    // Atributos

    // Constructor
    public Cuatro() {
        super("4");
    }

    // Métodos
    @Override
    public int orden() {
        return 4;
    }

    @Override
    public int devolverPuntaje() {
        return 4;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Tres;
    }


}