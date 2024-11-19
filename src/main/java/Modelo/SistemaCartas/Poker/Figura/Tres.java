package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Tres extends  Figura{

    // Atributos
    private  final  int puntaje = 3;

    // Constructor
    public Tres() {
        super("3");
    }

    // Métodos
    @Override
    public int orden() {
        return 3;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Tres;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Dos);
    }

}
