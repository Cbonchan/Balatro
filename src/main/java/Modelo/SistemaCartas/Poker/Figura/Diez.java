package Modelo.SistemaCartas.Poker.Figura;

// Importaciones

public class Diez  extends  Figura{
    // Atributos

    // Constructor
    public Diez() { super("10");}

    // Métodos
    @Override
    public int orden() {return 10;}

    @Override
    public int devolverPuntaje() {return 10;}

    @Override
    public boolean LeSigueA(Figura figura) {return figura instanceof Nueve;}
}
