package Modelo.SistemaCartas.Poker.Figura;

// Importaciones
import  Modelo.SistemaPuntaje.*;

public class Nueve extends  Figura {

    // Atributos
    private  final  int puntaje = 9;

    // Cnstructores
    public Nueve() {
        super("9");
    }

    // Métodos
    @Override
    public int orden() {
        return 9;
    }

    @Override
    public Puntaje asignarPuntaje() {
        return new Puntaje( new Chip(puntaje));
    }

    @Override
    public  boolean esIgualA(Figura figura){
        return figura instanceof Nueve;
    }

    @Override
    public boolean miSiguienteFiguraEs(Figura otraFigura){
        return  (otraFigura instanceof Ocho);
    }





}

