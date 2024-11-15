package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class Tres extends  Figura{

    // Atributos

    // Constructor
    public Tres() {
        super("3");
    }

    // Métodos
    @Override
    public int orden() {
        return 3;
    }

    @Override
    public int devolverPuntaje() {
        return 3;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Dos;
    }

}
