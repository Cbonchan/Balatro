package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class Nueve extends  Figura {
    // Atributos

    // Cnstructores
    public Nueve() {
        super("9");
    }

    // Métodos
    @Override
    public int orden() {
        return 9;
    }


    @Override
    public int devolverPuntaje() {
        return 9;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Ocho;
    }
}

