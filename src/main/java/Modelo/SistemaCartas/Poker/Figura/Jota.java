package Modelo.SistemaCartas.Poker.Figura;

public class Jota  extends  Figura{
    // Atributos

    // Constructor
    public Jota() {super("J");}

    // Métodos
    @Override
    public int orden() {return 11;}

    @Override
    public int devolverPuntaje() {return 10;}

    @Override
    public boolean LeSigueA(Figura figura) {return figura instanceof  Diez;}
}