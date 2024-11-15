package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
public class Seis extends Figura {
    // Atributos

    // Constructores
    public Seis() {
        super("6");
    }

    // Métodos
    @Override
    public int orden() {
        return 6;
    }

    @Override
    public int devolverPuntaje() {
        return 6;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Cinco;
    }
}