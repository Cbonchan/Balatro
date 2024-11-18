package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import Modelo.SistemaPuntaje.*;

public class Cuatro extends Figura{

    // Atributos
    private  final  int puntaje = 4;

    // Constructor
    public Cuatro(){super("4");}

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Tres);
    }






    @Override
    public int orden() {
        return 4;
    }

    @Override
    public int devolverPuntaje() {
        return 4;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Tres;
    }


}