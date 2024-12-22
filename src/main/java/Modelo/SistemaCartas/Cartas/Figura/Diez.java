package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Diez  extends  Figura{
    // Atributos
    private final  int puntaje = 10;

    // Constructor
    public Diez() {
        super("10");
    }

    // Métodos
    @Override
    public int orden() {return 10;}

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Diez;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Nueve);
    }

}
