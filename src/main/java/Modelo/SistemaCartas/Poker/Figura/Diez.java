package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Diez  extends  Figura{
    // Atributos
    private final  int puntaje = 10;

    // Constructor
    public Diez() { super("10");}

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Nueve);
    }






    @Override
    public int orden() {return 10;}

    @Override
    public int devolverPuntaje() {return 10;}

    @Override
    public boolean LeSigueA(Figura figura) {return figura instanceof Nueve;}
}
