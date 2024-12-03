package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import Modelo.SistemaPuntaje.*;

public class Cuatro extends Figura{

    // Atributos
    private  final  int puntaje = 4;

    // Constructor
    public Cuatro(){
        super("4");
    }

    // Métodos
    @Override
    public int orden() {
        return 4;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Cuatro;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Tres);
    }

}