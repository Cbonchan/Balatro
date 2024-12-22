package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import Modelo.SistemaPuntaje.*;

public class Reina extends Figura {

    // Atributos
    private  final int puntaje = 10;

    // Constructor
    public Reina() {
        super("Q");
    }

    // Métodos
    @Override
    public int orden() {
        return 12;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Reina;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Jota);
    }

}