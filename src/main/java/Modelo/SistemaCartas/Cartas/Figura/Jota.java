package Modelo.SistemaCartas.Cartas.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Jota  extends  Figura{

    // Atributos
    private  final int puntaje = 10;

    // Constructor
    public Jota() {
        super("J");
    }

    // Métodos
    @Override
    public int orden() {return 11;}

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Jota;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Diez);
    }




}