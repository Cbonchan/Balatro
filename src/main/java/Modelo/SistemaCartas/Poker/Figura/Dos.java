package Modelo.SistemaCartas.Poker.Figura;

// Impotaciones

public class Dos  extends Figura{

    // Atributos

    // Constructor
    public Dos() {
        super("2");
    }

    // Metodos
    @Override
    public int orden() {
        return 2;
    }

    @Override
    public int devolverPuntaje() {
        return 2;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof As;
    }


}