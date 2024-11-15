package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class Ocho extends  Figura{
    // Atributos

    // Constructores
    public Ocho() {
        super("8");
    }

    // Métodos
    @Override
    public int orden() {
        return 8;
    }

    @Override
    public int devolverPuntaje() {
        return 8;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Siete;
    }


}
