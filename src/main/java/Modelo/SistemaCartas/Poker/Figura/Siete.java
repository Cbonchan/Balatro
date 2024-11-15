package Modelo.SistemaCartas.Poker.Figura;

public class Siete extends Figura {
    // Atributos

    // Constructores
    public Siete() {
        super("7");
    }

    // Métodos
    @Override
    public int orden() {
        return 7;
    }

    @Override
    public int devolverPuntaje() {
        return 7;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Seis;
    }


}

