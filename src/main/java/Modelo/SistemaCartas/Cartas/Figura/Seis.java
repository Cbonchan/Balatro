package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Seis extends Figura {

    // Atributos
    private final int puntaje = 6;

    // Constructores
    public Seis() {
        super("6");

    }

    // Métodos
    @Override
    public int orden() {
        return 6;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Seis;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Cinco);
    }

}