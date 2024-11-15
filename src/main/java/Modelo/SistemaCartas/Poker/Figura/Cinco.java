package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class Cinco extends Figura{
    // Atributos

    // Constructores
    public Cinco() {
        super("5");
    }

    // Métodos

    @Override
    public int orden() {return 5;}

    @Override
    public int devolverPuntaje() {
        return 5;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Cuatro;
    }



}

