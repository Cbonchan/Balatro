package Modelo.SistemaCartas.Cartas.Figura;

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
    public int orden() {return 13;}

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Rey;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Reina);
    }

}