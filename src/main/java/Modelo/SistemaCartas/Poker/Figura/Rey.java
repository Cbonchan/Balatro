package Modelo.SistemaCartas.Poker.Figura;

// importaciones
import Modelo.SistemaPuntaje.*;

public class Rey extends Figura {

    // Atributos
    private  final int puntaje = 10;

    // Constructor
    public Rey() {
        super("K");
    }

    // Métodos
    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Reina);
    }


    @Override
    public int orden() {return 13;}

    @Override
    public int devolverPuntaje() {
        return 10;
    }

    @Override
    public boolean LeSigueA(Figura figura) {
        return figura instanceof Reina;
    }
}