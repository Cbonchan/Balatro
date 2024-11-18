package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Jota  extends  Figura{

    // Atributos
    private  final int puntaje = 10;

    // Constructor
    public Jota() {super("J");}

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Diez);
    }





    @Override
    public int orden() {return 11;}

    @Override
    public int devolverPuntaje() {return 10;}

    @Override
    public boolean LeSigueA(Figura figura) {return figura instanceof  Diez;}
}