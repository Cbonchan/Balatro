package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import Modelo.SistemaPuntaje.*;

public class Cinco extends Figura{

    // Atributos
    private  final int puntaje = 5;

    // Constructores
    public Cinco() {
        super("5");
    }

    // Métodos
    @Override
    public int orden() {return 5;}

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

   @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Cinco;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Cuatro);
    }

}

