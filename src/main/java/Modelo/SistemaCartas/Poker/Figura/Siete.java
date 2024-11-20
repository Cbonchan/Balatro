package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import Modelo.SistemaPuntaje.*;

public class Siete extends Figura {

    // Atributos
    private  final  int puntaje = 7;


    // Constructores
    public Siete() {
        super("7");
    }

    // Métodos
    @Override
    public int orden() {
        return 7;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Siete;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Seis);
    }




}

