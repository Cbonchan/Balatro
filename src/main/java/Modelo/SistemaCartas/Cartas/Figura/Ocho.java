package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Ocho extends  Figura{
    // Atributos
    private  final int puntaje = 8;


    // Constructores
    public Ocho() {
        super("8");
    }

    // Métodos
    @Override
    public int orden() {
        return 8;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Ocho;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Siete);
    }

}
